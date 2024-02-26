package ua.nure.cpp.lab1.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexNumberTest {

    @Test
    void testAdd() {
        ComplexNumber complex1 = new ComplexNumber(3, 2);
        ComplexNumber complex2 = new ComplexNumber(1, 7);
        ComplexNumber result = ComplexNumber.add(complex1, complex2);
        assertEquals(4, result.getReal());
        assertEquals(9, result.getImaginary());
    }

    @Test
    void testAddZero() {
        ComplexNumber complex1 = new ComplexNumber(3, 2);
        ComplexNumber complex2 = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexNumber.add(complex1, complex2);
        assertEquals(3, result.getReal());
        assertEquals(2, result.getImaginary());
    }

    @Test
    void testMultiply() {
        ComplexNumber complex1 = new ComplexNumber(3, 2);
        ComplexNumber complex2 = new ComplexNumber(1, 7);
        ComplexNumber result = ComplexNumber.multiply(complex1, complex2);
        assertEquals(-11, result.getReal());
        assertEquals(23, result.getImaginary());
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
    void testAddAll() {
        List<ComplexNumber> numbers1 = Arrays.asList(
                new ComplexNumber(3, 2),
                new ComplexNumber(1, 7),
                new ComplexNumber(2, 5)
        );
        ComplexNumber result1 = ComplexNumber.addAll(numbers1);
        assertEquals(6, result1.getReal());
        assertEquals(14, result1.getImaginary());

        List<ComplexNumber> numbers2 = Arrays.asList(
                new ComplexNumber(0, 0),
                new ComplexNumber(0, 0),
                new ComplexNumber(0, 0)
        );
        ComplexNumber result2 = ComplexNumber.addAll(numbers2);
        assertEquals(0, result2.getReal());
        assertEquals(0, result2.getImaginary());

        List<ComplexNumber> numbers3 = Arrays.asList(
                new ComplexNumber(-3, -2),
                new ComplexNumber(-1, -7),
                new ComplexNumber(-2, -5)
        );
        ComplexNumber result3 = ComplexNumber.addAll(numbers3);
        assertEquals(-6, result3.getReal());
        assertEquals(-14, result3.getImaginary());
    }

    @Test
    void testMultiplyAll() {
        List<ComplexNumber> numbers1 = Arrays.asList(
                new ComplexNumber(1, 2),
                new ComplexNumber(3, 4),
                new ComplexNumber(5, 6)
        );
        ComplexNumber result1 = ComplexNumber.multiplyAll(numbers1);
        assertEquals(-85, result1.getReal());
        assertEquals(20, result1.getImaginary());

        List<ComplexNumber> numbers2 = Arrays.asList(
                new ComplexNumber(0, 0),
                new ComplexNumber(0, 0),
                new ComplexNumber(0, 0)
        );
        ComplexNumber result2 = ComplexNumber.multiplyAll(numbers2);
        assertEquals(0, result2.getReal());
        assertEquals(0, result2.getImaginary());

        List<ComplexNumber> numbers3 = Arrays.asList(
                new ComplexNumber(-1, -2),
                new ComplexNumber(-3, -4),
                new ComplexNumber(-5, -6)
        );
        ComplexNumber result3 = ComplexNumber.multiplyAll(numbers3);
        assertEquals(85, result3.getReal());
        assertEquals(-20, result3.getImaginary());

        List<ComplexNumber> numbers4 = Arrays.asList(
                new ComplexNumber(1, 2),
                new ComplexNumber(0, 0),
                new ComplexNumber(3, 4)
        );
        ComplexNumber result4 = ComplexNumber.multiplyAll(numbers4);
        assertEquals(0, result4.getReal());
        assertEquals(0, result4.getImaginary());
    }

    @Test
    void testAddAllWithEmptyList() {
        List<ComplexNumber> numbers = Arrays.asList();
        ComplexNumber result = ComplexNumber.addAll(numbers);
        assertEquals(0, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void testAddAllWithNull() {
        List<ComplexNumber> numbers = null;
        ComplexNumber result = ComplexNumber.addAll(numbers);
        assertEquals(0, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void testMultiplyAllWithEmptyList() {
        List<ComplexNumber> numbers = Arrays.asList();
        ComplexNumber result = ComplexNumber.multiplyAll(numbers);
        assertEquals(0, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void testMultiplyAllWithNull() {
        List<ComplexNumber> numbers = null;
        ComplexNumber result = ComplexNumber.multiplyAll(numbers);
        assertEquals(0, result.getReal());
        assertEquals(0, result.getImaginary());
    }
}
