package ua.nure.cpp.lab1.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void testDistanceToOrigin() {
        ComplexNumber coordinates = new ComplexNumber(3, 4);
        Point point = new Point(coordinates);
        double distance = point.distanceToOrigin();
        assertEquals(5, distance);
    }

    @Test
    void testMultiplyByZero() {
        ComplexNumber complex1 = new ComplexNumber(3, 2);
        ComplexNumber complex2 = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexNumber.multiply(complex1, complex2);
        assertEquals(0, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void testDistanceToPoint() {
        ComplexNumber coordinates1 = new ComplexNumber(3, 4);
        Point point1 = new Point(coordinates1);
        ComplexNumber coordinates2 = new ComplexNumber(6, 8);
        Point point2 = new Point(coordinates2);
        double distance = point1.distanceToPoint(point2);
        assertEquals(5, distance);
    }

    @Test
    void testDistanceToPointAtSamePoint() {
        ComplexNumber coordinates1 = new ComplexNumber(3, 4);
        Point point1 = new Point(coordinates1);
        ComplexNumber coordinates2 = new ComplexNumber(3, 4);
        Point point2 = new Point(coordinates2);
        double distance = point1.distanceToPoint(point2);
        assertEquals(0, distance);
    }

    @Test
    void testDistanceToOriginAtOrigin() {
        ComplexNumber coordinates = new ComplexNumber(0, 0);
        Point point = new Point(coordinates);
        double distance = point.distanceToOrigin();
        assertEquals(0, distance);
    }

    @Test
    void testDistanceToPointDifferentQuadrants() {
        ComplexNumber coordinates1 = new ComplexNumber(-3, 4);
        Point point1 = new Point(coordinates1);
        ComplexNumber coordinates2 = new ComplexNumber(6, -8);
        Point point2 = new Point(coordinates2);
        double distance = point1.distanceToPoint(point2);
        assertEquals(15, distance);
    }

    @Test
    void testDistanceToPointOnAxis() {
        ComplexNumber coordinates1 = new ComplexNumber(0, 5);
        Point point1 = new Point(coordinates1);
        ComplexNumber coordinates2 = new ComplexNumber(3, 0);
        Point point2 = new Point(coordinates2);
        double distance = point1.distanceToPoint(point2);
        assertEquals(5.830951894845301, distance);
    }
}
