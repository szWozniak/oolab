package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass extends AbstractMapElement {
    private Vector2d location;
    private IWorldMap map;
    private List<IPositionChangeObserver> observerList = new ArrayList<IPositionChangeObserver>();

    public Grass(IWorldMap map, Vector2d vector2d) {
        this.location = vector2d;
        this.map = map;
    }

    public Vector2d getLocation() {
        return location;
    }

    public String toString() {
        return "*";
    }
}
