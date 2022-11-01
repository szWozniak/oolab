package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        if(width <= 0) this.width = 4;
        else this.width = width;

        if(height <= 0) this.height = 4;
        else this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getLocation())) return false;
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : this.animals) {
            if(animal.getLocation().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals) {
            if(animal.getLocation().equals(position)) return animal;
        }
        return null;
    }

    public String toString() {
        MapVisualiser visualiser = new MapVisualiser(this);
        return visualiser.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
