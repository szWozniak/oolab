package agh.ics.oop;

import static agh.ics.oop.MapDirection.NORTH;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;

    public Animal() {
        this.orientation = NORTH;
        this.location = new Vector2d(2, 2);
    }

    public String toString() {
        return this.location.toString() + " " + orientation.toString();
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getLocation() {
        return this.location;
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.location);
    }

    public void moveMap(MapDirection orientation, boolean opposite) {
        Vector2d moveVector = switch (orientation) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
        if(opposite) {
            moveVector = moveVector.opposite();
        }

        if(this.location.add(moveVector).precedes(new Vector2d(4, 4)) && this.location.add(moveVector).follows(new Vector2d(0, 0))) {
            this.location = this.location.add(moveVector);
        }
    }

    public void move(MoveDirection direction) {
        if(direction == null) return;
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> this.moveMap(this.orientation, false);
            case BACKWARD -> this.moveMap(this.orientation, true);
        }

    }
}
