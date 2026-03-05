package DSA;

import java.util.ArrayList;

public class HashTable {
    private static final int TREEIFY_THRESHOLD = 8;
    private static final int UNTREEIFY_THRESHOLD = 6;
    private int defaultSize = 11;
    private LinkedListNode[] dataMap;
    private boolean[] isTree;
    private int[] bucketSize;


    interface Node {

        String getKey();

        int getValue();

        void setValue(int value);
    }

    class LinkedListNode implements Node {
        String key;
        int value;
        LinkedListNode next;

        public LinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public int getValue() {
            return this.value;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }
    }

    class TreeNode implements Node {
        String key;
        int value;
        TreeNode left, right;

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public int getValue() {
            return this.value;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new LinkedListNode[defaultSize];
    }

    public HashTable(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive!");
        dataMap = new LinkedListNode[size];
    }

    public void printHashTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            LinkedListNode temp = dataMap[i];
            while (temp != null) {
                System.out.println("   [Key: " + temp.key + " | Value: " + temp.value + "]");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyToCharArray = key.toCharArray();
        for (int i = 0; i < keyToCharArray.length; i++) {
            int asciiValue = keyToCharArray[i];
            hash = (hash + asciiValue * 7919) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null!");
        int index = hash(key);
        LinkedListNode newNode = new LinkedListNode(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
            return;
        }
        LinkedListNode temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        newNode.next = dataMap[index];
        dataMap[index] = newNode;

    }

    public Integer get(String key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null!");
        int index = hash(key);
        if (dataMap[index] == null) return null;
        LinkedListNode temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            LinkedListNode temp = dataMap[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

}

