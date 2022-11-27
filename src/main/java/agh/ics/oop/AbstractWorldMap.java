package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, IMapElement> elements = new HashMap<>();
    public MapBoundary boundary = new MapBoundary();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, element);
    }

    public MapBoundary getBoundary() {
        return this.boundary;
    }

    public void positionChanged(IMapElement element, boolean remove, boolean add) { }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedWithAnimal(position);
    }

    public boolean isOccupiedWithAnimal(Vector2d position) {
        if(elements.containsKey(position)) {
            return elements.get(position) instanceof Animal;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return elements.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(elements.containsKey(position)) {
            return elements.get(position);
        }
        return null;
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getLocation())) return false;
        elements.put(animal.getLocation(), animal);
        return true;
    }

    public String toString() {
        MapVisualiser visualiser = new MapVisualiser(this);
        return visualiser.draw(boundary.getLeftBottom(), boundary.getTopRight());
    }
}
