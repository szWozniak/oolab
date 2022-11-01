package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void TestInput() {
        //given:
        String[] strings = {"f", "backward", "none", "right", "f", "l", "forward"};

        //when:
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map);
        for(MoveDirection move : OptionsParser.parse(strings)) {
            animal.move(move);
        }

        //then:
        assertEquals(animal.getLocation(), new Vector2d(3, 3));
    }
}