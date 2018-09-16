package graph;

import java.rmi.MarshalException;
import java.util.LinkedList;

public class Graph {
    //Terminology
    //dense graph: more edges
    //sparse graph: less edges
    //Digraph: directed graph
    //Undirected graph.
    //weighted graph, unweighted graph
    //Cyclic graphs and Acyclic graphs
    //Max edges in digraph (without self loop): n(n-1)
    //Max edges in undirected graph: n(n-1)/2
    //Strongly connected: A path exists from any vertex to any other vertex
    //Graph representation: Edge List (O(E) time for operations). Adjacency matrix(waste of space). Adjacency List (best for sparse graphs)


    private int v;
    private LinkedList<Integer>[] adjMatrix;

    public Graph(int v) {
        this.v = v;
        adjMatrix = new LinkedList[v + 1];

        for (int i = 0; i <= v; i++) {
            adjMatrix[i] = new LinkedList<>();
        }
    }

    public void add(int v, int w) {
        adjMatrix[v].add(w);
        adjMatrix[w].add(v);
    }

    public void print() {
        for (int i = 0; i <= v; i++) {
            for (int val : adjMatrix[i]) {
                System.out.println(i + "-->" + val);
            }
        }
    }

    public int degree(int v) {
        int degree = 0;
        for (int w : adjMatrix[v]) degree++;

        return degree;
    }

    public int maxDegree() {
        int maxDegree = 0;
        for (int i = 0; i <= v; i++) {
            if (degree(i) > maxDegree) maxDegree = degree(i);
        }
        return maxDegree;
    }

    public int selfLoopCount() {
        int count = 0;

        for (int i = 0; i <= v; i++) {
            for (int w : adjMatrix[i]) {
                if (i == w) count++;
            }
        }

        return count / 2;
    }

    public void dfs() {
        boolean[] visited = new boolean[v + 1];
        dfs(visited, 1);
    }

    public void dfs(boolean[] visited, int source) {
        visited[source] = true;
        System.out.println(source);
        for (int w : adjMatrix[source]) {
            if (!visited[w]) {
                dfs(visited, w);
            }
        }
    }

}
