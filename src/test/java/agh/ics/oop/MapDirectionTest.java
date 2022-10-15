package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void testNext() {
        //given:
        MapDirection[] mapDirections = {NORTH, SOUTH, EAST, WEST};
        MapDirection[] correctResults = {EAST, WEST, SOUTH, NORTH};

        //when:
        for(int i = 0; i < 4; i++) {
            mapDirections[i] = mapDirections[i].next();
        }

        //then:
        for(int i = 0; i < 4; i++) {
            assertEquals(mapDirections[i], correctResults[i]);
        }
    }

    @Test
    void testPrevious() {
        //given:
        MapDirection[] mapDirections = {NORTH, SOUTH, EAST, WEST};
        MapDirection[] correctResults = {WEST, EAST, NORTH, SOUTH};

        //when:
        for(int i = 0; i < 4; i++) {
            mapDirections[i] = mapDirections[i].previous();
        }

        //then:
        for(int i = 0; i < 4; i++) {
            assertEquals(mapDirections[i], correctResults[i]);
        }
    }
}