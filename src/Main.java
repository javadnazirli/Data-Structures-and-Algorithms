import DSA.*;

import java.sql.SQLOutput;

import static DSA.SortingAlgorithms.*;

void main() {
//    LL myList = new LL(6);
//    DLL myDLL = new DLL(10);
//    Stack myStack = new Stack(20);
//    Queue myQueue = new Queue(100);
//    BinarySearchTree myBST = new BinarySearchTree();
//    HashTable myHashTable = new HashTable();
//    Graph myGraph = new Graph();
//    Heap myHeap = new Heap();
    // Test 1 - Normal array
    // Test 1 - Normal array

    int[] arr1 = {4, 6, 1, 7, 3};
    System.out.println("Before: " + Arrays.toString(arr1));
    quickSort(arr1);
    System.out.println("After:  " + Arrays.toString(arr1));

    // Test 2 - Already sorted
    int[] arr2 = {1, 2, 3, 4, 5};
    System.out.println("\nBefore: " + Arrays.toString(arr2));
    quickSort(arr2);
    System.out.println("After:  " + Arrays.toString(arr2));

    // Test 3 - Reverse sorted (worst case)
    int[] arr3 = {5, 4, 3, 2, 1};
    System.out.println("\nBefore: " + Arrays.toString(arr3));
    quickSort(arr3);
    System.out.println("After:  " + Arrays.toString(arr3));

    // Test 4 - Single element
    int[] arr4 = {42};
    System.out.println("\nBefore: " + Arrays.toString(arr4));
    quickSort(arr4);
    System.out.println("After:  " + Arrays.toString(arr4));

    // Test 5 - Two elements
    int[] arr5 = {9, 3};
    System.out.println("\nBefore: " + Arrays.toString(arr5));
    quickSort(arr5);
    System.out.println("After:  " + Arrays.toString(arr5));

    // Test 6 - Duplicate elements
    int[] arr6 = {3, 1, 3, 2, 1};
    System.out.println("\nBefore: " + Arrays.toString(arr6));
    quickSort(arr6);
    System.out.println("After:  " + Arrays.toString(arr6));

    // Test 7 - All same elements
    int[] arr7 = {5, 5, 5, 5};
    System.out.println("\nBefore: " + Arrays.toString(arr7));
    quickSort(arr7);
    System.out.println("After:  " + Arrays.toString(arr7));

}