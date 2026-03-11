package DSA;

/**
 * Queue Implementation using a Singly Linked List.
 *
 * A Queue is a FIFO (First In, First Out) data structure.
 * Elements are added to the back and removed from the front.
 *
 * Structure:  first -> [1] -> [2] -> [3] -> null
 *                                           ↑ last
 *
 * enqueue → adds to last   O(1)
 * dequeue → removes first  O(1)
 */
public class Queue {
    private Node first;
    private Node last;
    private int length;

    /**
     * Internal node structure for the queue.
     * Each node holds a value and a reference to the next node.
     */
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initializes the queue with a single node.
     *
     * @param value the value of the first node
     */
    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    /**
     * Prints all values in the queue from first to last.
     * Time Complexity: O(n)
     */
    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Returns the value of the first node without removing it.
     * Time Complexity: O(1)
     *
     * @return the value of the first node
     * @throws NullPointerException if the queue is empty
     */
    public int getFirst() {
        if (first == null) throw new NullPointerException("DSA.Queue is empty");
        return first.value;
    }

    /**
     * Returns the value of the last node without removing it.
     * Time Complexity: O(1)
     *
     * @return the value of the last node
     * @throws NullPointerException if the queue is empty
     */
    public int getLast() {
        if (last == null) throw new NullPointerException("DSA.Queue is empty");
        return last.value;
    }

    /**
     * Returns the number of elements in the queue.
     * Time Complexity: O(1)
     *
     * @return the length of the queue
     */
    public int getLength() {
        return length;
    }

    /**
     * Adds a new node to the end of the queue.
     * Time Complexity: O(1)
     *
     * @param value the value to enqueue
     */
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    /**
     * Removes and returns the first node from the queue.
     * Time Complexity: O(1)
     *
     * @return the removed Node
     * @throws NullPointerException if the queue is empty
     */
    public Node dequeue() {
        if (length == 0) throw new NullPointerException("DSA.Queue is empty!");
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}