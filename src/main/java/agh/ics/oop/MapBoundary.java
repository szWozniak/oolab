package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    TreeSet<IMapElement> horizontal = new TreeSet<IMapElement>(new Comparator<IMapElement>() {
        @Override
        public int compare(IMapElement o1, IMapElement o2) {
            return o1.getLocation().x() - o2.getLocation().x();
        }
    });

    TreeSet<IMapElement> vertical = new TreeSet<IMapElement>(new Comparator<IMapElement>() {
        @Override
        public int compare(IMapElement o1, IMapElement o2) {
            return o1.getLocation().y() - o2.getLocation().y();
        }
    });

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) { }

    public void positionChanged(IMapElement element, boolean remove, boolean add) {
        System.out.println(getLeftBottom().toString() + " " + getTopRight().toString());
        if(remove) {
            this.horizontal.remove(element);
            this.vertical.remove(element);
        }
        if(add) {
            this.horizontal.add(element);
            this.vertical.add(element);
        }
    }

    public Vector2d getLeftBottom() {
        if(this.horizontal.size() != 0 && this.vertical.size() != 0)
            return new Vector2d(this.horizontal.first().getLocation().x(), this.vertical.first().getLocation().y());
        else
            return new Vector2d(0, 0);
    }

    public Vector2d getTopRight() {
        if(this.horizontal.size() != 0 && this.vertical.size() != 0)
            return new Vector2d(this.horizontal.last().getLocation().x(), this.vertical.last().getLocation().y());
        else
            return new Vector2d(0, 0);
    }
}
