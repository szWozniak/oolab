package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;
import static agh.ics.oop.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void TestOrientation() {
        //given:
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map);
        Animal animal2 = new Animal(map);
        Animal animal3 = new Animal(map);

        //when:
        animal.move(RIGHT);
        animal.move(RIGHT);
        animal2.move(LEFT);
        animal3.move(LEFT);
        animal3.move(LEFT);

        //then:
        assertEquals(animal.getOrientation(), SOUTH);
        assertEquals(animal2.getOrientation(), WEST);
        assertEquals(animal3.getOrientation(), SOUTH);
    }

    @Test
    void TestPositionAndMap() {
        //given:
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map);
        Animal animal2 = new Animal(map);

        //when:
        animal.move(RIGHT);
        animal2.move(LEFT);
        animal2.move(LEFT);
        for(int i = 0; i < 10; i++) {
            animal.move(FORWARD);
            animal2.move(FORWARD);
        }
        animal.move(BACKWARD);

        //then:
        assertEquals(animal.getLocation(), new Vector2d(3,2));
        assertEquals(animal2.getLocation(), new Vector2d(2,0));
    }
}