package ua.nure.cpp.lab1.computations.readers;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleArrayReader extends InputStreamArrayReader {
    public ConsoleArrayReader(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int[] read() {
        try (Scanner sc = new Scanner(inputStream)) {
            System.out.println("How many numbers do you want to process?");

            int numberCount;
            do {
                System.out.print("Please, enter a positive integer value: ");
                numberCount = getIntValue(sc);
            } while (numberCount <= 0);

            int[] numbers = new int[numberCount];

            System.out.println("Enter numbers one by one:");
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getIntValue(sc);
            }

            return numbers;
        }
    }

    private int getIntValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer value: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
