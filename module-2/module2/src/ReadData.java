//Jessica Long-Heinicke CSD 420 Module 2 3.30.25

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("longheinicke_datafile.dat"))) {
            System.out.println("Contents of longheinicke_datafile.dat:");
            System.out.println("-------------------------------------");

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("-------------------------------------");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}