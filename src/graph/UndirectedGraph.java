package graph;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph implements Graph {
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

    public int v;
    public LinkedList<Integer>[] adjMatrix;

    public UndirectedGraph(int v) {
        this.v = v;
        adjMatrix = new LinkedList[v + 1];

        for (int i = 0; i <= v; i++) {
            adjMatrix[i] = new LinkedList<>();
        }
    }

    @Override
    public int getVertexCount() {
        return v;
    }

    @Override
    public void add(int v, int w) {
        adjMatrix[v].add(w);
        adjMatrix[w].add(v);
    }

    @Override
    public Iterable<Integer> getAdjList(int source) {
        return adjMatrix[source];
    }
}
