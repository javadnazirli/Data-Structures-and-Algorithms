package DSA;

public class BinarySearchTree {
    private Node root;

    static class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
        }

    }

    public Node getRoot() {
        return root;
    }


    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.value == newNode.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }

        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (temp.value > value) {
                temp = temp.left;
            } else if (temp.value < value) {
                temp = temp.right;
            } else return true;

        }
        return false;
    }

    public int minValue() {
        if (root == null) throw new NullPointerException("Tree is empty!");
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.value;

    }

    public int maxValue() {
        if (root == null) throw new NullPointerException("Tree is empty!");
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.value;

    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if (currentNode.value > value) return rContains(currentNode.left, value);
        else return rContains(currentNode.right, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if (currentNode.value > value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        if (currentNode.value < value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    private Node delete(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) currentNode.left = delete(currentNode.right, value);
        else if (value > currentNode.value) currentNode.right = delete(currentNode.right, value);
        else {
            if (currentNode.left == null && currentNode.right == null) return null;
            else if (currentNode.left == null) currentNode = currentNode.right;
            else if (currentNode.right == null) currentNode = currentNode.left;
            else {

            }
        }
        return currentNode;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node rMinValue(Node currentNode) {
        if (currentNode.left == null) return currentNode;
        return rMinValue(currentNode.left);
    }

    public Integer rMinValue() {
        if (root == null) return null;
        return rMinValue(root).value;
    }


}
