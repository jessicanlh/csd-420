//Jessica Long-Heinicke 4.6.25 Module 3

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {
    public static void main(String[] args) {
        // Create an ArrayList with 50 random values between 1 and 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1); // Generates numbers 1-20
        }

        System.out.println("Original list (" + originalList.size() + " elements):");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList without duplicates (" + uniqueList.size() + " elements):");
        System.out.println(uniqueList);
    }

    /**
     * Returns a new ArrayList with all unique elements from the original list
     * @param <E> the type of elements in the list
     * @param list the original ArrayList
     * @return a new ArrayList containing only unique elements from the original
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}