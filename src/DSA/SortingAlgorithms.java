package DSA;

import java.util.ArrayList;

public class SortingAlgorithms {
    /**
     * Bubble Sort <p>
     * Best Case  - Ω(n)    - Already sorted, no swaps occur, exits early<p>
     * Average    - Θ(n²)   - Randomly ordered<p>
     * Worst Case - O(n²)   - Reverse sorted, every element is swapped
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null) throw new NullPointerException("Array is null!");
        int temp = 0;
        boolean swap;
        for (int i = array.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
        return array;
    }

    /**
     * Selection Sort<p>
     * Best Case  - Ω(n²)   - Inner loop always runs to find minimum<p>
     * Average    - Θ(n²)   - Randomly ordered<p>
     * Worst Case - O(n²)   - Reverse sorted
     */
    public static int[] selectionSort(int[] array) {
        if (array == null) throw new NullPointerException("Array is null!");
        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minimumIndex] > array[j]) {
                    minimumIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
        return array;
    }

    /**
     * Insertion Sort<p>
     * Best Case  - Ω(n)    - Already sorted, while loop never executes<p>
     * Average    - Θ(n²)   - Randomly ordered<p>
     * Worst Case - O(n²)   - Reverse sorted, every element shifts left
     */
    public static int[] insertionSort(int[] array) {
        if (array == null) throw new NullPointerException("Array is null!");
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
