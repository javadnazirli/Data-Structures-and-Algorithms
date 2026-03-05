package DSA;

public class LL {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LL(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

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

    public void removeFirst() {

        if (head == null) return;
        else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            length--;
        }
        if (length == 0) {
            tail = null;
        }
    }

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

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length) return false;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > length) {
            return false;
        }
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

    public boolean remove(int index) {
        if (head == null || index < 0 || index >= length) return false;

        Node temp = head;
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
                temp = get(index - 1);
                Node toRemove = temp.next;
                temp.next = toRemove.next;
                toRemove.next = null; // optional
                length--;
            }
        }
        return true;
    }

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
