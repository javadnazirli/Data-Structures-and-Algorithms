package DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


//    public boolean insert(int value) {
//        Node newNode = new Node(value);
//        if (root == null) {
//            root = newNode;
//            return true;
//        }
//        Node temp = root;
//        while (true) {
//            if (temp.value == newNode.value) {
//                return false;
//            }
//            if (newNode.value < temp.value) {
//                if (temp.left == null) {
//                    temp.left = newNode;
//                    return true;
//                }
//                temp = temp.left;
//            } else {
//                if (temp.right == null) {
//                    temp.right = newNode;
//                    return true;
//                }
//                temp = temp.right;
//            }
//
//        }
//    }

//    public boolean contains(int value) {
//        if (root == null) return false;
//        Node temp = root;
//        while (temp != null) {
//            if (temp.value > value) {
//                temp = temp.left;
//            } else if (temp.value < value) {
//                temp = temp.right;
//            } else return true;
//
//        }
//        return false;
//    }

//    public int minValue() {
//        if (root == null) throw new NullPointerException("Tree is empty!");
//        Node temp = root;
//        while (temp.left != null) {
//            temp = temp.left;
//        }
//        return temp.value;
//
//    }

//    public int maxValue() {
//        if (root == null) throw new NullPointerException("Tree is empty!");
//        Node temp = root;
//        while (temp.right != null) {
//            temp = temp.right;
//        }
//        return temp.value;
//
//    }

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

    private Node rDelete(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) currentNode.left = rDelete(currentNode.left, value);
        else if (value > currentNode.value) currentNode.right = rDelete(currentNode.right, value);
        else {
            if (currentNode.left == null && currentNode.right == null) return null;
            else if (currentNode.left == null) currentNode = currentNode.right;
            else if (currentNode.right == null) currentNode = currentNode.left;
            else {
                int subTreeMinValue = rMinValue(currentNode.right).value;
                currentNode.value = subTreeMinValue;
                currentNode.right = rDelete(currentNode.right, subTreeMinValue);
            }
        }
        return currentNode;
    }

    public void rDelete(int value) {
        root = rDelete(root, value);
    }

    private Node rMinValue(Node currentNode) {
        if (currentNode.left == null) return currentNode;
        return rMinValue(currentNode.left);
    }

    public Integer rMinValue() {
        if (root == null) return null;
        return rMinValue(root).value;
    }

    private Node rMaxValue(Node currentNode) {
        if (currentNode.right == null) return currentNode;
        return rMaxValue(currentNode.right);
    }

    public Integer rMaxValue() {
        if (root == null) return null;
        return rMaxValue(root).value;
    }

    public ArrayList<Integer> BFS() {
        if (root == null) return null;
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        traverseDFSPreOrder(root, results);
        return results;
    }

    private void traverseDFSPreOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;
        results.add(currentNode.value);
        traverseDFSPreOrder(currentNode.left, results);
        traverseDFSPreOrder(currentNode.right, results);
    }
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        traverseDFSPostOrder(root, results);
        return results;
    }

    private void traverseDFSPostOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;
        traverseDFSPostOrder(currentNode.left, results);
        traverseDFSPostOrder(currentNode.right, results);
        results.add(currentNode.value);
    }
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        traverseDFSInOrder(root, results);
        return results;
    }

    private void traverseDFSInOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;
        traverseDFSInOrder(currentNode.left, results);
        results.add(currentNode.value);
        traverseDFSInOrder(currentNode.right, results);

    }



}
