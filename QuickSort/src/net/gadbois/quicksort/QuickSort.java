package net.gadbois.quicksort;

/**
 *
 Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm.
 Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements.
 Quicksort can then recursively sort the sub-lists.

 Steps to implement Quick sort:

 1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
 2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it
 (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
 3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.

 The complexity of quick sort in the average case is Θ(n log(n)) and in the worst case is Θ(n2).

 - See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.rS14TN9s.dpuf
 */
public class QuickSort {
    private int array[];
    private int length;

    public void sort(int[] input) {
        if ((input == null) || (input.length == 0)) {
            return;
        }
        this.array = input;
        this.length = input.length;
        quickSort(0, length - 1);
    }
    private void quickSort(int lowwerIndex, int upperIndex) {
        int i = lowwerIndex;
        int j = upperIndex;
        int pivot = array[lowwerIndex + (upperIndex-lowwerIndex) / 2];
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (lowwerIndex < j) {
            quickSort(lowwerIndex, j);
        }
        if (i < upperIndex) {
            quickSort(i, upperIndex);
        }
    }

    private void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
