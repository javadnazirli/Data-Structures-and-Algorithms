package DSA;

public class DLL {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node prev;
        Node next;


        public Node(int value) {
            this.value = value;
        }
    }

    public DLL(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

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

    public Node get(int index) {
        if (length == 0) return null;
        if (index < 0 || length <= index) return null;
        Node temp = null;
        if (index <= length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }

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

        else {
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            length++;
            return true;

        }
    }

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
