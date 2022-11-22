package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.MapDirection.NORTH;

public class Animal implements IMapElement {
    private MapDirection orientation;
    private Vector2d location;
    private IWorldMap map;
    private List<IPositionChangeObserver> observerList = new ArrayList<IPositionChangeObserver>();

    public Animal(IWorldMap map) {
        this.orientation = NORTH;
        this.location = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = NORTH;
        this.map = map;
        this.location = initialPosition;
    }

    public String toString() {
        return switch(this.orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
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

    private void moveMap(MapDirection orientation, boolean opposite) {
        Vector2d moveVector = switch (orientation) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
        if(opposite) {
            moveVector = moveVector.opposite();
        }

        Vector2d moveTo = this.location.add(moveVector);
        if(this.map.canMoveTo(moveTo)) {
            this.positionChanged(this.location, moveTo);
            this.map.wasMoved(moveTo);
            this.location = moveTo;
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

    public void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for(IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
