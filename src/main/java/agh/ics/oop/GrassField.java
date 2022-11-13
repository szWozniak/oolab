package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private int grassCount;

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        this.randomGrassTiles(grassCount);
    }

    private void randomGrassTiles(int grassCount) {
        for(int i = 0; i < grassCount; i++) {
            this.elements.add(new Grass(randomEmptyGrass()));
        }
    }

    public Vector2d randomEmptyGrass() {
        Random rand = new Random();

        Vector2d randomed;
        do {
            System.out.println((int)Math.sqrt(this.grassCount*10));
            randomed = new Vector2d(rand.nextInt((int)Math.sqrt(this.grassCount*10)), rand.nextInt((int)Math.sqrt(this.grassCount*10)));
        } while(this.isOccupied(randomed));

        return randomed;
    }

    protected Vector2d getLeftBottom() {
        int left = 0;
        int bottom = 0;
        for(IMapElement element : this.elements) {
            left = Math.min(left, element.getLocation().x());
            bottom = Math.min(bottom, element.getLocation().y());
        }
        return new Vector2d(left-1, bottom-1);
    }

    protected Vector2d getTopRight() {
        int right = 0;
        int top = 0;
        for(IMapElement element : this.elements) {
            right = Math.max(right, element.getLocation().x());
            top = Math.max(top, element.getLocation().y());
        }
        return new Vector2d(right+1, top+1);
    }

    @Override
    public void wasMoved(Vector2d vector2d) {
        if(objectAt(vector2d) instanceof Grass) {
            this.randomGrassTiles(1);
            this.elements.remove((IMapElement) objectAt(vector2d));
        }
    }
}
