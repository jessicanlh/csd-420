//Jessica Long-Heinicke Module 4 4.6.25

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Test with 50,000 elements
        System.out.println("Testing with 50,000 elements:");
        testLinkedListPerformance(50_000);

        // Test with 500,000 elements
        System.out.println("\nTesting with 500,000 elements:");
        testLinkedListPerformance(500_000);
    }

    public static void testLinkedListPerformance(int size) {
        // Create and populate the LinkedList
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Test iterator traversal
        long startTime = System.nanoTime();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long iteratorTime = System.nanoTime() - startTime;
        System.out.printf("Iterator traversal time: %,d ns%n", iteratorTime);

        // Test get(index) traversal
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        long getTime = System.nanoTime() - startTime;
        System.out.printf("get(index) traversal time: %,d ns%n", getTime);

        // Calculate ratio
        double ratio = (double)getTime / iteratorTime;
        System.out.printf("get(index) is %.1f times slower than iterator%n", ratio);

        // Verify both methods traversed the same elements (test correctness)
        verifyCorrectness(list);
    }

    private static void verifyCorrectness(List<Integer> list) {
        // Verify iterator traversal
        ListIterator<Integer> iterator = list.listIterator();
        int expected = 0;
        boolean iteratorCorrect = true;
        while (iterator.hasNext()) {
            if (iterator.next() != expected++) {
                iteratorCorrect = false;
                break;
            }
        }

        // Verify get(index) traversal
        boolean getCorrect = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i) {
                getCorrect = false;
                break;
            }
        }

        if (iteratorCorrect && getCorrect) {
            System.out.println("Correctness test: PASSED (both methods traversed all elements correctly)");
        } else {
            System.out.println("Correctness test: FAILED");
        }
    }
}

/*The performance difference between iterator traversal and get(index) traversal in a LinkedList is due to
fundamental differences in how these operations work. When using an iterator, the LinkedList maintains a
pointer to the current position, allowing each subsequent element to be accessed in constant time. This
makes the total traversal time linear (O(n)) relative to the list size, as each element is visited exactly
once.
 */

/*In contrast, the get(index) method must start from the beginning of the list each time it is called.
For each index i, the LinkedList has to traverse all previous nodes from the head of the list until it
reaches the desired position. This means accessing element at position 0 takes 1 step, position 1 takes
2 steps, and so on until position n-1 which takes n steps. The cumulative effect creates a quadratic time
 complexity (O(n²)), as the total number of operations becomes the sum of the first n natural numbers
 (n(n+1)/2).
 */

/*For 50,000 elements, this quadratic behavior already shows a dramatic slowdown compared to the linear
 iterator approach. When scaling up to 500,000 elements, the performance gap becomes even more extreme
  because the quadratic algorithm's time requirement grows much faster than the linear one. The iterator's
  time will increase by roughly a factor of 10 (since 500,000 is 10 times 50,000), while the get(index)
  method's time will increase by about a factor of 100 (following the n² relationship).
 */

/*This example clearly demonstrates why LinkedLists should always be traversed using iterators rather
than index-based access when processing all elements. The correctness verification confirms that both
methods produce the same results, proving the performance difference stems entirely from algorithmic
efficiency rather than functional differences. The lesson holds particularly true for large datasets
where algorithmic complexity becomes the dominant factor in performance.
 */