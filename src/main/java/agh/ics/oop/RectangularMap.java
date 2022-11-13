package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d mapLimit;

    public RectangularMap(int width, int height) {
        if(width <= 0) width = 4;
        if(height <= 0) height = 4;
        this.mapLimit = new Vector2d(width, height);
    }

    protected Vector2d getLeftBottom() {
        return new Vector2d(0, 0);
    }

    protected Vector2d getTopRight() {
        return this.mapLimit;
    }

    @Override
    public void wasMoved(Vector2d vector2d) {

    }
}
