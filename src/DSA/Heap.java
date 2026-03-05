package DSA;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int currentPosition = heap.size() - 1;
        while (currentPosition > 0 && heap.get(currentPosition) > heap.get(parent(currentPosition))) {
            swap(currentPosition, parent(currentPosition));
            currentPosition = parent(currentPosition);
        }
    }

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
