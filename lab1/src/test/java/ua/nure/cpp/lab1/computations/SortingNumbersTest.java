package ua.nure.cpp.lab1.computations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingNumbersTest {

    @Test
    @DisplayName("Test case 1: Input numbers in ascending order of their length")
    void testCase1() {
        String input = "5\n1\n22\n333\n4444\n55555\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SortingNumbers sortingNumbers = new SortingNumbers();
        sortingNumbers.sortInputNumbers();

        int[] expected = {1, 22, 333, 4444, 55555};
        assertArrayEquals(expected, sortingNumbers.getNumbers());
    }

    @Test
    @DisplayName("Test case 2: Input numbers in descending order of their length")
    void testCase2() {
        String input = "5\n55555\n4444\n333\n22\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SortingNumbers sortingNumbers = new SortingNumbers();
        sortingNumbers.sortInputNumbers();

        int[] expected = {1, 22, 333, 4444, 55555};
        assertArrayEquals(expected, sortingNumbers.getNumbers());
    }

    @Test
    @DisplayName("Test case 3: Sorting should work correctly even if there are not only integer numbers in the input stream")
    void testCase3() {
        String input = "t\nkert\n10\n5\n-4\n9\n0\nak\n4\nrk\n3\n4\n5\n0\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SortingNumbers sortingNumbers = new SortingNumbers();
        sortingNumbers.sortInputNumbers();

        int[] expected = {-4, 0, 0, 1, 3, 4, 4, 5, 5, 9};
        assertArrayEquals(expected, sortingNumbers.getNumbers());
    }

    @Test
    @DisplayName("Test case 4: Sorting should work correctly even if user is trying to pass negative values when defining of size of an input values is requested")
    void testCase4() {
        String input = "-1\n0\n6\n39\n-1\n2\n0\nak\n7\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SortingNumbers sortingNumbers = new SortingNumbers();
        sortingNumbers.sortInputNumbers();

        int[] expected = {-1, 0, 2, 6, 7, 39};
        assertArrayEquals(expected, sortingNumbers.getNumbers());
    }

    @Test
    @DisplayName("Test case 5: Sorting should work correctly for an input of size 1")
    void testCase5() {
        String input = "1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SortingNumbers sortingNumbers = new SortingNumbers();
        sortingNumbers.sortInputNumbers();

        int[] expected = {0};
        assertArrayEquals(expected, sortingNumbers.getNumbers());
    }
}
