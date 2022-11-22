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
            this.elements.put(randomed, new Grass(randomed));
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
        AtomicInteger left = new AtomicInteger();
        AtomicInteger bottom = new AtomicInteger();
        this.elements.forEach((key, value) -> {
            left.set(Math.min(left.get(), key.x()));
            bottom.set(Math.min(bottom.get(), key.y()));
        });
        return new Vector2d(left.get() - 1, bottom.get() - 1);
    }

    protected Vector2d getTopRight() {
        AtomicInteger right = new AtomicInteger();
        AtomicInteger top = new AtomicInteger();
        this.elements.forEach((key, value) -> {
            right.set(Math.max(right.get(), key.x()));
            top.set(Math.max(top.get(), key.y()));
        });
        return new Vector2d(right.get() + 1, top.get() + 1);
    }

    @Override
    public void wasMoved(Vector2d vector2d) {
        if(objectAt(vector2d) instanceof Grass) {
            this.randomGrassTiles(1);
        }
    }
}
