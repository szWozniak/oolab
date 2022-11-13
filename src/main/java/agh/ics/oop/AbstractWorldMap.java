package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<IMapElement> elements = new ArrayList<>();;

    protected abstract Vector2d getLeftBottom();

    protected abstract Vector2d getTopRight();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.getTopRight()) && position.follows(this.getLeftBottom()) && !isOccupiedWithAnimal(position);
    }

    public boolean isOccupiedWithAnimal(Vector2d position) {
        for(IMapElement element : this.elements) {
            if(element instanceof Animal && element.getLocation().equals(position)) return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(IMapElement element : this.elements) {
            if(element.getLocation().equals(position)) return true;
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element : this.elements) {
            if(element.getLocation().equals(position)) return element;
        }
        return null;
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getLocation())) return false;
        elements.add(animal);
        return true;
    }

    public String toString() {
        MapVisualiser visualiser = new MapVisualiser(this);
        return visualiser.draw(getLeftBottom(), getTopRight());
    }
}
