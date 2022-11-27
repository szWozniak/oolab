package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapElement implements IMapElement {
    protected List<IPositionChangeObserver> observerList = new ArrayList<IPositionChangeObserver>();

    public void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for(IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(oldPosition, newPosition);
            observer.positionChanged(this, true, true);
        }
    }

    public void placed() {
        for(IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(this, false, true);
        }
    }

    public void removed() {
        System.out.println("REMOVING GRASS");
        for(IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(this, true, false);
        }
    }
}
