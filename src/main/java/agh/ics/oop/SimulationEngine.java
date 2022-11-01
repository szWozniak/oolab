package agh.ics.oop;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();
    private MoveDirection[] directions;

    private JFrame frame;
    private JTextArea field;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] vectors) {
        this.map = map;
        this.addAnimals(vectors);
        this.directions = directions;

        this.setupFrame();
    }

    private void setupFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        field = new JTextArea();
        field.setBounds(50, 50, 390, 360);
        field.setText(this.map.toString());
        Font font = new Font("Courier New", Font.BOLD, 23);
        field.setFont(font);
        frame.add(field);
    }

    private void addAnimals(Vector2d[] vectors) {
        for(Vector2d vector : vectors) {
            if(!this.map.isOccupied(vector)) {
                Animal animal = new Animal(this.map, vector);
                this.map.place(animal);
                this.animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int n = this.animals.size();
        for(int i = 0; i < directions.length; i++) {
            try {
                Thread.sleep(300);
            } catch(InterruptedException e) {
                System.out.println("Interrupted!");
            }
            this.animals.get(i%n).move(directions[i]);
            field.setText(this.map.toString());
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}
