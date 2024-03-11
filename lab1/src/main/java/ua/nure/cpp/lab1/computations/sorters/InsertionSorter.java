package ua.nure.cpp.lab1.computations.sorters;

public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] numbers) {
        if (numbers.length == 1) {
            return;
        }

        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];

            int j = i - 1;
            while (j >= 0 && current < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = current;
        }
    }
}
