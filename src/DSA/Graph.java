package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Undirected Graph Implementation using an Adjacency List.
 *
 * Structure: HashMap where each key is a vertex and
 * each value is a HashSet of its neighboring vertices.
 *
 * Example:
 *   "A" -> ["B", "C"]
 *   "B" -> ["A", "C"]
 *   "C" -> ["A", "B"]
 */
public class Graph {

    private HashMap<String, HashSet<String>> adjList = new HashMap<>();

    /**
     * Adds a new vertex to the graph.
     * Time Complexity: O(1)
     *
     * @param vertex the name of the vertex to add
     * @return true if added successfully, false if vertex already exists
     */
    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new HashSet<String>());
            return true;
        }
        return false;
    }

    /**
     * Adds an undirected edge between two existing vertices.
     * Time Complexity: O(1)
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return true if edge added successfully, false if either vertex does not exist
     */
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    /**
     * Removes the edge between two vertices.
     * Time Complexity: O(1)
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return true if edge removed successfully, false if either vertex does not exist
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    /**
     * Removes a vertex and all its associated edges from the graph.
     * Time Complexity: O(V + E)
     *
     * @param vertex the vertex to remove
     * @return true if removed successfully, false if vertex does not exist
     */
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

    /**
     * Returns the total number of vertices in the graph.
     * Time Complexity: O(1)
     *
     * @return the number of vertices
     */
    public int vertexCount() {
        return adjList.size();
    }

    /**
     * Prints each vertex and its neighbors to the console.
     * Time Complexity: O(V + E)
     */
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