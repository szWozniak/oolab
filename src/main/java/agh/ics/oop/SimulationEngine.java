package agh.ics.oop;

import org.w3c.dom.css.Rect;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();
    private MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] vectors) {
        this.map = map;
        this.addAnimals(vectors);
        this.directions = directions;
    }

    private void addAnimals(Vector2d[] vectors) {
        for(Vector2d vector : vectors) {
            if(!this.map.isOccupiedWithAnimal(vector)) {
                Animal animal = new Animal(this.map, vector);
                animal.addObserver((IPositionChangeObserver) map);
                this.map.place(animal);
                this.animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int n = this.animals.size();
        for(int i = 0; i < directions.length; i++) {
            this.animals.get(i%n).move(directions[i]);
            System.out.print(this.map.toString());
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}
