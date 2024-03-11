package ua.nure.cpp.lab1.computations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.nure.cpp.lab1.computations.readers.ConsoleArrayReader;
import ua.nure.cpp.lab1.computations.sorters.InsertionSorter;
import ua.nure.cpp.lab1.computations.sorters.Sorter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaskProcessorTest {
    TaskProcessor taskProcessor;

    @BeforeEach
    void initiateTaskProcessor() {
        Sorter sorter = new InsertionSorter();
        taskProcessor = TaskProcessor.builder().sorter(sorter).build();
    }

    @Test
    @DisplayName("Should throw IllegalStateException when ArrayReader is not set")
    void shouldThrowIllegalStateExceptionWhenArrayReaderIsNotSet() {
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> taskProcessor.process());

        String expectedErrorMessage = "ArrayReader has not been initialized. Read actions couldn't been performed.";
        assertEquals(expectedErrorMessage, illegalStateException.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSorting(String input, int[] expected) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        taskProcessor.setReader(new ConsoleArrayReader(in));
        taskProcessor.process();

        assertArrayEquals(expected, taskProcessor.getNumbers());
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("5\n1\n22\n333\n4444\n55555\n", new int[]{1, 22, 333, 4444, 55555}),
                Arguments.of("5\n55555\n4444\n333\n22\n1\n", new int[]{1, 22, 333, 4444, 55555}),
                Arguments.of("t\nkert\n10\n5\n-4\n9\n0\nak\n4\nrk\n3\n4\n5\n0\n1\n", new int[]{-4, 0, 0, 1, 3, 4, 4, 5, 5, 9}),
                Arguments.of("-1\n0\n6\n39\n-1\n2\n0\nak\n7\n6\n", new int[]{-1, 0, 2, 6, 7, 39}),
                Arguments.of("1\n0\n", new int[]{0}),
                Arguments.of("0\n-4\n1\n5", new int[]{5})
        );
    }
}
