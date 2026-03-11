package DSA;

/**
 * Stack Implementation using a Singly Linked List.
 *
 * A Stack is a LIFO (Last In, First Out) data structure.
 * Elements are added and removed from the top only.
 *
 * Structure:  top
 *              ↓
 *             [3] -> [2] -> [1] -> null
 *
 * push → adds to top      O(1)
 * pop  → removes from top O(1)
 */
public class Stack {
    private Node top;
    private int height;

    /**
     * Internal node structure for the stack.
     * Each node holds a value and a reference to the next node.
     */
    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initializes the stack with a single node.
     *
     * @param value the value of the first node
     */
    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    /**
     * Prints all values in the stack from top to bottom.
     * Time Complexity: O(n)
     */
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Returns the value of the top node without removing it.
     * Time Complexity: O(1)
     *
     * @return the value of the top node
     * @throws RuntimeException if the stack is empty
     */
    public int peek() {
        if (top == null) throw new RuntimeException("DSA.Stack is empty! Cannot peek.");
        return top.value;
    }

    /**
     * Prints the current height of the stack.
     * Time Complexity: O(1)
     */
    public void getHeight() {
        System.out.println("Height: " + height);
    }

    /**
     * Pushes a new node onto the top of the stack.
     * Time Complexity: O(1)
     *
     * @param value the value to push
     */
    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    /**
     * Removes and returns the top node from the stack.
     * Time Complexity: O(1)
     *
     * @return the removed Node, or null if the stack is empty
     */
    public Node pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}