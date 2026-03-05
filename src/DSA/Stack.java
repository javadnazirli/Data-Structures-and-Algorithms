package DSA;

public class Stack {
    private Node top;
    private int height;


    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }


    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int peek() {
        if (top == null) {
            throw new RuntimeException("DSA.Stack is empty! Cannot peek.");
        }
        return top.value;
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

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

    public Node pop() {
        if (height == 0) return null;
        else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;
            return temp;
        }
    }
}
