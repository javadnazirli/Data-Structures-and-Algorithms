package DSA;

/**
 * Singly Linked List (LL) Implementation.
 *
 * A linear data structure where each node holds a value
 * and a pointer to the next node.
 *
 * Structure:  [val|next] -> [val|next] -> [val|null]
 *              ↑ head                      ↑ tail
 *
 * Differences from Doubly Linked List (DLL):
 *  - Each node only has a next pointer (no prev)
 *  - get() always traverses from head → O(n)
 *  - removeLast() requires traversal to find new tail → O(n)
 */
public class LL {
    private Node head;
    private Node tail;
    private int length;

    /**
     * Internal node structure for the singly linked list.
     * Each node holds a value and a reference to the next node.
     */
    class Node {
        int value;
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
    public LL(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    /**
     * Prints all values in the list from head to tail.
     * Time Complexity: O(n)
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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
            tail = newNode;
        }
        length++;
    }

    /**
     * Removes the last node from the list.
     * Requires traversal to find the new tail.
     * Time Complexity: O(n)
     */
    public void removeLast() {
        if (head == null) return;
        if (length == 1) {
            tail = null;
            head = null;
            return;
        } else if (length > 1) {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        length--;
    }

    /**
     * Removes the first node from the list.
     * Time Complexity: O(1)
     */
    public void removeFirst() {
        if (head == null) return;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
    }

    /**
     * Prepends a new node to the beginning of the list.
     * Time Complexity: O(1)
     *
     * @param value the value to prepend
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Returns the node at the given index.
     * Always traverses from head.
     * Time Complexity: O(n)
     *
     * @param index the position to retrieve (0-based)
     * @return the Node at the index, or null if invalid
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
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
        if (index < 0 || index >= length) return false;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
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
        Node newNode = new Node(value);
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node temp = get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
        return true;
    }

    /**
     * Removes the node at the given index.
     * Delegates to removeFirst/removeLast for edge cases.
     * Time Complexity: O(n)
     *
     * @param index the position to remove (0-based)
     * @return true if successful, false if index is invalid or list is empty
     */
    public boolean remove(int index) {
        if (head == null || index < 0 || index >= length) return false;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
        } else {
            if (index == 0) {
                removeFirst();
            } else if (index == length - 1) {
                removeLast();
            } else {
                Node temp = get(index - 1);
                Node toRemove = temp.next;
                temp.next = toRemove.next;
                toRemove.next = null;
                length--;
            }
        }
        return true;
    }

    /**
     * Reverses the list in place by re-wiring all next pointers.
     * Time Complexity: O(n)
     * <p>
     * Before: head -> [1] -> [2] -> [3] -> null
     * <p>
     * After:  head -> [3] -> [2] -> [1] -> null
     */
    public void reverse() {
        Node temp = head;
        Node before = null;
        Node after;
        tail = head;
        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        head = before;
    }
}