package agh.ics.oop;

public class Grass implements IMapElement {
    private Vector2d location;

    public Grass(Vector2d vector2d) {
        this.location = vector2d;
    }

    public Vector2d getLocation() {
        return location;
    }

    public String toString() {
        return "*";
    }
}
