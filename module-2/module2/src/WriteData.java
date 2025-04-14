//Jessica Long-Heinicke CSD420 Module 2 3.30.25

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate 5 random integers (1-100)
        int[] randomIntegers = new int[5];
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = random.nextInt(100) + 1;
        }

        // Generate 5 random doubles (1.0-100.0, rounded to 2 decimal places)
        double[] randomDoubles = new double[5];
        for (int i = 0; i < 5; i++) {
            randomDoubles[i] = Math.round(random.nextDouble() * 99.0 * 100.0) / 100.0 + 1.0;
        }

        // Write data to file (append mode)
        try (PrintWriter writer = new PrintWriter(new FileWriter("longheinicke_datafile.dat", true))) {
            // Write integers
            writer.print("Integers: ");
            for (int i = 0; i < 5; i++) {
                writer.print(randomIntegers[i]);
                if (i < 4) writer.print(", ");
            }
            writer.println();

            // Write doubles
            writer.print("Doubles: ");
            for (int i = 0; i < 5; i++) {
                writer.print(randomDoubles[i]);
                if (i < 4) writer.print(", ");
            }
            writer.println();

            System.out.println("Data written to longheinicke_datafile.dat");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}