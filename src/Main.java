import DSA.*;

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

    System.out.println(myBST.rMinValue());
}