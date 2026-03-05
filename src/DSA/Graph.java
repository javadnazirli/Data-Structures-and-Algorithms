package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    private HashMap<String, HashSet<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new HashSet<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            ArrayList<String> neighbors = new ArrayList<>(adjList.get(vertex));
            for (String neighbor : neighbors) {
                removeEdge(vertex, neighbor);
            }
            adjList.remove(vertex);
            return true;
        }
        return false;
    }

    public int vertexCount() {
        return adjList.size();
    }

    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> [ ");
            for (String neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println("]");
        }
    }

}
