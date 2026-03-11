import DSA.*;

import java.sql.SQLOutput;

import static DSA.SortingAlgorithms.bubbleSort;

void main() {
    LL myList = new LL(6);
    DLL myDLL = new DLL(10);
    Stack myStack = new Stack(20);
    Queue myQueue = new Queue(100);
    BinarySearchTree myBST = new BinarySearchTree();
    HashTable myHashTable = new HashTable();
    Graph myGraph = new Graph();
    Heap myHeap = new Heap();
    // Test 1 - Normal array
    int[] arr1 = {4, 2, 7, 1, 3};
    System.out.println("Önce: " + Arrays.toString(arr1));
    bubbleSort(arr1);
    System.out.println("Sonra: " + Arrays.toString(arr1));

    // Test 2 - Zaten sıralı (swap flag test)
    int[] arr2 = {1, 2, 3, 4, 5};
    System.out.println("\nÖnce: " + Arrays.toString(arr2));
    bubbleSort(arr2);
    System.out.println("Sonra: " + Arrays.toString(arr2));

    // Test 3 - Ters sıralı (en kötü durum)
    int[] arr3 = {5, 4, 3, 2, 1};
    System.out.println("\nÖnce: " + Arrays.toString(arr3));
    bubbleSort(arr3);
    System.out.println("Sonra: " + Arrays.toString(arr3));

    // Test 4 - Tek eleman
    int[] arr4 = {42};
    System.out.println("\nÖnce: " + Arrays.toString(arr4));
    bubbleSort(arr4);
    System.out.println("Sonra: " + Arrays.toString(arr4));

    // Test 5 - Null (exception test)
    try {
        bubbleSort(null);
    } catch (NullPointerException e) {
        System.out.println("\nNull yakalandı: " + e.getMessage());
    }
}