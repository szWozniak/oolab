package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void testEquals() {
        //given:
        Vector2d vector2d = new Vector2d(4, 7);
        Vector2d vectorFailCompare = new Vector2d(4, 8);
        Vector2d vectorSuccessCompare = new Vector2d(4, 7);

        //when:
        boolean resultFail = vector2d.equals(vectorFailCompare) || vectorFailCompare.equals(vector2d);
        boolean resultSuccess = vector2d.equals(vectorSuccessCompare) && vectorSuccessCompare.equals(vector2d);

        //then:
        assertFalse(resultFail);
        assertTrue(resultSuccess);
    }

    @Test
    void testToString() {
        //given:
        Vector2d vector2dA = new Vector2d(4, 8);
        Vector2d vector2dB = new Vector2d(3, -8);

        //when:
        String stringA = vector2dA.toString();
        String stringB = vector2dB.toString();

        //then:
        assertEquals(stringA, "(4,8)");
        assertEquals(stringB, "(3,-8)");
    }

    @Test
    void testPrecedesAndFollows() {
        //given:
        Vector2d vector2dA = new Vector2d(4, 5);
        Vector2d vector2dB = new Vector2d(1, 2);

        //when:
        boolean resultFail = vector2dA.precedes(vector2dB) || vector2dB.follows(vector2dA);
        boolean resultSuccess = vector2dB.precedes(vector2dA) && vector2dA.follows(vector2dB);

        //then:
        assertFalse(resultFail);
        assertTrue(resultSuccess);
    }

    @Test
    void testUpperRightAndLowerLeft() {
        //given:
        Vector2d vector2dA = new Vector2d(1, 12);
        Vector2d vector2dB = new Vector2d(-4, 13);
        Vector2d correctUpperRight = new Vector2d(1, 13);
        Vector2d correctLowerLeft = new Vector2d(-4, 12);

        //when:
        Vector2d resultUpperRight = vector2dA.upperRight(vector2dB);
        Vector2d resultLowerLeft = vector2dB.lowerLeft(vector2dA);

        //then:
        assertEquals(resultUpperRight, correctUpperRight);
        assertEquals(resultLowerLeft, correctLowerLeft);
    }

    @Test
    void testAddAndSubtract() {
        //given:
        Vector2d vector2dA = new Vector2d(4, 8);
        Vector2d vector2dB = new Vector2d(3, -8);
        Vector2d correctSum = new Vector2d(7, 0);
        Vector2d correctFirstDiff = new Vector2d(1, 16);
        Vector2d correctSecondDiff = new Vector2d(-1, -16);

        //when:
        Vector2d sum = vector2dA.add(vector2dB);
        Vector2d firstDiff = vector2dA.subtract(vector2dB);
        Vector2d secondDiff = vector2dB.subtract(vector2dA);

        //then:
        assertEquals(sum, correctSum);
        assertEquals(firstDiff, correctFirstDiff);
        assertEquals(secondDiff, correctSecondDiff);
    }

    @Test
    void testOpposite() {
        //given:
        Vector2d vector2d = new Vector2d(73, -168);
        Vector2d correctOpposite = new Vector2d(-73, 168);

        //when:
        Vector2d opposite = vector2d.opposite();

        //then:
        assertEquals(opposite, correctOpposite);
    }
}