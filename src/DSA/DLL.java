package DSA;
/**
 * Doubly Linked List (DLL) Implementation
 *
 * A linear data structure where each node holds a value and
 * pointers to both the previous and next nodes.
 *
 * Structure:  null <- [prev|val|next] <-> [prev|val|next] -> null
 *                      ↑ head                               ↑ tail
 *
 * Advantages over Singly Linked List:
 *  - Can traverse in both directions
 *  - O(1) removal from both ends
 *  - get() is optimized: starts from head or tail depending on index
 */
public class DLL {
    private Node head;
    private Node tail;
    private int length;

    /**
     * Internal node structure for the doubly linked list.
     * Each node holds a value and references to adjacent nodes.
     */
    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initializes the list with a single node.
     *
     * @param value the value of the first node
     */
    public DLL(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    /**
     * Appends a new node to the end of the list.
     * Time Complexity: O(1)
     *
     * @param value the value to append
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    /**
     * Removes the last node from the list.
     * Time Complexity: O(1)
     */
    public void removeLast() {
        if (length == 0) return;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = tail;
            tail = tail.prev;
            temp.prev = null;
            tail.next = null;
        }
        length--;
    }

    /**
     * Prepends a new node to the beginning of the list.
     * Time Complexity: O(1)
     *
     * @param value the value to prepend
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
            temp.prev = head;
        }
        length++;
    }

    /**
     * Removes the first node from the list.
     * Time Complexity: O(1)
     */
    public void removeFirst() {
        if (length == 0) return;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
    }

    /**
     * Returns the node at the given index.
     * Optimized: traverses from head or tail depending on index.
     * Time Complexity: O(n/2) → O(n)
     *
     * @param index the position to retrieve (0-based)
     * @return the Node at the index, or null if invalid
     */
    public Node get(int index) {
        if (length == 0) return null;
        if (index < 0 || length <= index) return null;
        Node temp = null;
        if (index <= length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    /**
     * Updates the value of the node at the given index.
     * Time Complexity: O(n)
     *
     * @param index the position to update (0-based)
     * @param value the new value
     * @return true if successful, false if index is invalid
     */
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }

    /**
     * Inserts a new node at the given index.
     * Delegates to prepend/append for edge cases.
     * Time Complexity: O(n)
     *
     * @param index the position to insert at (0-based)
     * @param value the value to insert
     * @return true if successful, false if index is invalid
     */
    public boolean insert(int index, int value) {
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        if (temp == null) return false;
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next.prev = newNode;
        length++;
        return true;
    }

    /**
     * Removes the node at the given index.
     * Delegates to removeFirst/removeLast for edge cases.
     * Time Complexity: O(n)
     *
     * @param index the position to remove (0-based)
     */
    public void remove(int index) {
        if (index < 0 || index >= length) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == length - 1) {
            removeLast();
            return;
        }
        Node temp = get(index - 1);
        Node target = temp.next;
        temp.next = target.next;
        target.next.prev = temp;
        target.next = null;
        target.prev = null;
        length--;
    }
}