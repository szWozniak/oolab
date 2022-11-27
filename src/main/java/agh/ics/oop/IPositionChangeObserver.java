package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
    void positionChanged(IMapElement element, boolean remove, boolean add);
}
