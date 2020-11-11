package com.omar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CoordinatesTests
{
    @Test
    public void shouldConstructCoordinateFromComponents() {
        Coordinates coordinates = new Coordinates(5, 2);
        assertEquals(5, coordinates.getX());
        assertEquals(2, coordinates.getY());
    }

    @Test
    public void coordinatesWithEqualComponentsShouldEqual() {
        Coordinates coordinates1 = new Coordinates(5, 2);
        Coordinates coordinates2 = new Coordinates(5, 2);
        assertEquals(coordinates1, coordinates2);
    }

    @Test
    public void coordinatesWithDifferentComponentsShouldNotEqual() {
        Coordinates coordinates1 = new Coordinates(1, 0);
        Coordinates coordinates2 = new Coordinates(-2, 3);
        assertNotEquals(coordinates1, coordinates2);
    }

    @Test
    public void equalCoordinatesShouldHaveSameHashCode() {
        Coordinates coordinates1 = new Coordinates(-7, 3);
        Coordinates coordinates2 = new Coordinates(-7, 3);
        assertEquals(coordinates1.hashCode(), coordinates2.hashCode());
    }
}
