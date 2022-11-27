package agh.ics.oop;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GrassField extends AbstractWorldMap {
    private int grassCount;

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        this.randomGrassTiles(grassCount);
    }

    private void randomGrassTiles(int grassCount) {
        for(int i = 0; i < grassCount; i++) {
            Vector2d randomed = randomEmptyGrass();
            Grass newGrass = new Grass(this, randomed);
            newGrass.addObserver((IPositionChangeObserver) this);
            newGrass.addObserver((IPositionChangeObserver) this.getBoundary());
            newGrass.placed();
            this.elements.put(randomed, newGrass);
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

    @Override
    public void wasMoved(Vector2d vector2d) {
        if(objectAt(vector2d) instanceof Grass) {
            ((Grass)objectAt(vector2d)).removed();
            this.randomGrassTiles(1);
        }
    }
}
