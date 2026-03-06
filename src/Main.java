import DSA.*;

import java.sql.SQLOutput;

void main() {
    LL myList = new LL(6);
    DLL myDLL = new DLL(10);
    Stack myStack = new Stack(20);
    Queue myQueue = new Queue(100);
    BinarySearchTree myBST = new BinarySearchTree();
    HashTable myHashTable = new HashTable();
    Graph myGraph = new Graph();
    Heap myHeap = new Heap();
    myBST.rInsert(50);
    myBST.rInsert(20);
    myBST.rInsert(5);
    myBST.rInsert(70);
    myBST.rInsert(570);
    myBST.rInsert(80);
    myBST.rInsert(90);
    myBST.rInsert(540);
    System.out.println(myBST.rMaxValue());
    System.out.println("-----------------------------");
    System.out.println(myBST.BFS());
}