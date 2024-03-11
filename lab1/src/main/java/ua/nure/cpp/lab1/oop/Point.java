package ua.nure.cpp.lab1.oop;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Point {
    private ComplexNumber coordinates;

    /**
     * Calculates the distance from this point to the origin (0,0).
     * <p>
     * The distance is calculated using the Pythagorean theorem.
     *
     * @return the distance from this point to the origin
     */
    public double distanceToOrigin() {
        return Math.sqrt(Math.pow(coordinates.getReal(), 2) + Math.pow(coordinates.getImaginary(), 2));
    }

    /**
     * Calculates the distance from this point to another point.
     * <p>
     * The distance is calculated using the Pythagorean theorem.
     *
     * @param other the other point to which the distance is to be calculated
     * @return the distance from this point to the other point
     */
    public double distanceToPoint(Point other) {
        double realDiff = Math.abs(other.coordinates.getReal() - this.coordinates.getReal());
        double imaginaryDiff = Math.abs(other.coordinates.getImaginary() - this.coordinates.getImaginary());
        return Math.sqrt(realDiff * realDiff + imaginaryDiff * imaginaryDiff);
    }
}
