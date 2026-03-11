package DSA;

import java.util.ArrayList;
import java.util.List;

/**
 * Max-Heap Implementation using an ArrayList.
 *
 * A Max-Heap is a complete binary tree where every parent
 * is greater than or equal to its children.
 *
 * Structure (stored as array):
 *        100
 *       /    \
 *      75     50
 *     /  \
 *    55   60
 *
 * Array: [100, 75, 50, 55, 60]
 *
 * Index formulas:
 *   Left  child  →  2i + 1
 *   Right child  →  2i + 2
 *   Parent       →  (i - 1) / 2
 */
public class Heap {
    private List<Integer> heap;

    /**
     * Initializes an empty Max-Heap.
     */
    public Heap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Returns a copy of the internal heap list.
     * Returns a copy to protect internal state from external modification.
     * Time Complexity: O(n)
     *
     * @return a new ArrayList containing all heap elements
     */
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    /**
     * Returns the index of the left child of the given node.
     * Time Complexity: O(1)
     *
     * @param index the index of the parent node
     * @return the index of the left child
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of the right child of the given node.
     * Time Complexity: O(1)
     *
     * @param index the index of the parent node
     * @return the index of the right child
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Returns the index of the parent of the given node.
     * Time Complexity: O(1)
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Swaps two elements in the heap by their indices.
     * Time Complexity: O(1)
     *
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     */
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Inserts a new value into the heap and bubbles it up
     * to maintain the Max-Heap property.
     * Time Complexity: O(log n)
     *
     * @param value the value to insert
     */
    public void insert(int value) {
        heap.add(value);
        int currentPosition = heap.size() - 1;
        while (currentPosition > 0 && heap.get(currentPosition) > heap.get(parent(currentPosition))) {
            swap(currentPosition, parent(currentPosition));
            currentPosition = parent(currentPosition);
        }
    }

    /**
     * Removes and returns the maximum value (root) from the heap.
     * Replaces root with the last element and sinks it down
     * to maintain the Max-Heap property.
     * Time Complexity: O(log n)
     *
     * @return the maximum value, or null if the heap is empty
     */
    public Integer remove() {
        if (heap.size() == 0) return null;
        if (heap.size() == 1) {
            return heap.removeFirst();
        }
        int maxValue = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        sinkDown(0);
        return maxValue;
    }

    /**
     * Sinks down a node to its correct position
     * to restore the Max-Heap property after removal.
     * Time Complexity: O(log n)
     *
     * @param index the index of the node to sink down
     */
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) maxIndex = leftIndex;
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) maxIndex = rightIndex;
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else return;
        }
    }
}