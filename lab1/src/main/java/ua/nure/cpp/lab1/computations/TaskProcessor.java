package ua.nure.cpp.lab1.computations;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
public class TaskProcessor {
    @NonNull
    private Sorter sorter;

    @Setter
    private ArrayReader reader;

    @Getter
    private int[] numbers;

    public void process() {
        if (reader == null) {
            throw new IllegalStateException("ArrayReader has not been initialized. Read actions couldn't been performed.");
        }
        numbers = reader.read();
        sorter.sort(numbers);
    }
}
