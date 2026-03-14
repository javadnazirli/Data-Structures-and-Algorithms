package DSA;

import java.util.ArrayList;
import java.util.Arrays;

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

    /**
     * Merge - Combines two sorted arrays into one sorted array.
     * <p>
     * Uses three pointers (i, j, index) to compare and place
     * elements from both arrays in order.
     * <p>
     * Example:
     * array1 = [1, 3, 5]
     * array2 = [2, 4, 6]
     * result = [1, 2, 3, 4, 5, 6]
     * <p>
     * Time Complexity:  O(n + m)
     * Space Complexity: O(n + m)
     *
     * @param array1 the first sorted array
     * @param array2 the second sorted array
     * @return a new merged and sorted array
     * @throws NullPointerException if both arrays are null
     */
    private static int[] merge(int[] array1, int[] array2) {
        if (array1 == null) return array2;
        if (array2 == null) return array1;
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // compare elements from both arrays and add the smaller one
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }
        // copy remaining elements from array1 if any
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        // copy remaining elements from array2 if any
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    /**
     * Merge Sort - Divide and Conquer Sorting Algorithm
     * <p>
     * Recursively splits the array in half, sorts each half,
     * then merges them back together using the merge() method.
     * <p>
     * Visualization:
     * [3, 1, 4, 2]
     *    /       \
     * [3, 1]    [4, 2]
     *  /  \      /  \
     * [3] [1]   [4] [2]
     *  \  /      \  /
     * [1,3]     [2,4]
     *   \      /
     * [1,2,3,4]
     * <p>
     * Best Case  - Ω(n log n) - Always divides and merges
     * Average    - Θ(n log n) - Randomly ordered
     * Worst Case - O(n log n) - Always divides and merges
     * <p>
     * Space Complexity: O(n) - new arrays created at each level
     *
     * @param array the array to sort
     * @return a new sorted array
     */
    public static int[] mergeSort(int[] array) {
        if (array == null) throw new NullPointerException("Array is null!");
        if (array.length == 1) return array;
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    /**
     * Swaps two elements in the array by their indices.
     * Time Complexity:  O(1)
     * Space Complexity: O(1)
     *
     * @param array       the array containing the elements
     * @param firstIndex  the index of the first element
     * @param secondIndex the index of the second element
     */
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    /**
     * Partitions the array around a pivot element.
     * All elements smaller than the pivot are moved to its left,
     * all greater elements to its right.
     *
     * Example:
     *   Before: [4, 6, 1, 7, 3]  pivotIndex=0
     *   After:  [3, 1, 4, 7, 6]  returns 2
     *                   ↑ pivot in correct position
     *
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     *
     * @param array      the array to partition
     * @param pivotIndex the index of the pivot element
     * @param endIndex   the last index of the partition range
     * @return the final index of the pivot element
     */
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    /**
     * Recursively sorts a subarray using the Quick Sort algorithm.
     * Partitions around a pivot, then recursively sorts both halves.
     *
     * Visualization:
     *   [4, 6, 1, 7, 3]
     *         ↓ pivot=4
     *   [3, 1, 4, 7, 6]
     *    ↙          ↘
     *  [1, 3]      [6, 7]
     *
     * Time Complexity:  O(n log n) average, O(n²) worst case
     * Space Complexity: O(log n) - recursive call stack
     *
     * @param array the array to sort
     * @param left  the starting index of the subarray
     * @param right the ending index of the subarray
     */
    private static void quickSortCore(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortCore(array, left, pivotIndex - 1);
            quickSortCore(array, pivotIndex + 1, right);
        }
    }

    /**
     * Quick Sort - Divide and Conquer Sorting Algorithm.
     * Sorts the entire array in place using quickSortCore().
     *
     * Best Case  - Ω(n log n) - Pivot always splits array evenly
     * Average    - Θ(n log n) - Randomly ordered
     * Worst Case - O(n²)      - Pivot is always smallest or largest element
     *
     * Space Complexity: O(log n) - recursive call stack depth
     *
     * @param array the array to sort
     */
    public static void quickSort(int[] array) {
        quickSortCore(array, 0, array.length - 1);
    }

}