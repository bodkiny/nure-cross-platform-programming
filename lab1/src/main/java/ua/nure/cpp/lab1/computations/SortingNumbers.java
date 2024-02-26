package ua.nure.cpp.lab1.computations;

import java.util.Arrays;
import java.util.Scanner;

public class SortingNumbers {
    private int[] numbers;

    public void sortInputNumbers() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("How many numbers do you want to process?");


            int numberCount;
            do {
                System.out.print("Please, enter a positive integer value: ");
                numberCount = getIntValue(sc);
            } while (numberCount <= 0);

            System.out.println("Enter numbers one by one:");
            numbers = new int[numberCount];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getIntValue(sc);
            }

            insertionSort();

            System.out.print("\nSorted numbers: ");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + (i < numbers.length - 1 ? ", " : ""));
            }
        }
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    private int getIntValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer value: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private void insertionSort() {
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
