//Jessica Long-Heinicke CSD420 4.20.25

public class BubbleSort {

    public static void main(String[] args) {
        int[] testValues = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        printArray(testValues); // Print initial array

        boolean swapped;
        for (int i = 0; i < testValues.length - 1; i++) {
            swapped = false;
            // Optimize inner loop to reduce comparison range each pass
            for (int j = 0; j < testValues.length - 1 - i; j++) {
                if (testValues[j] > testValues[j + 1]) {
                    // Swap elements
                    int temp = testValues[j];
                    testValues[j] = testValues[j + 1];
                    testValues[j + 1] = temp;
                    swapped = true;
                    System.out.println("Switch made");
                }
            }
            printArray(testValues); // Print after each pass
            if (!swapped) {
                break; // Early exit if no swaps
            }
        }

        printArray(testValues); // Final sorted array
    }

    public static void printArray(int[] arrayParam) {
        System.out.print("array = {");
        for (int e : arrayParam) {
            System.out.print(" [" + e + "] ");
        }
        System.out.println("};");
    }
}