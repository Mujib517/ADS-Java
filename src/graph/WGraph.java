package graph;

import java.util.LinkedList;

//Wieghted Graph
public class WGraph {

    private int v;
    private LinkedList<GraphEdge>[] adjList;

    public WGraph(int v) {
        this.v = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertextCount() {
        return v;
    }

    public Iterable<GraphEdge> getAdjList(int source) {
        return adjList[source];
    }

    public void add(int v, GraphEdge edge) {
        adjList[v].add(edge);
    }
}
