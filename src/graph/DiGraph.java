package graph;

import java.util.LinkedList;

public class DiGraph implements Graph {

    private int v;
    private LinkedList<Integer>[] adj;

    public DiGraph(int v) {
        this.v = v;
        adj = new LinkedList[v + 1];

        for (int i = 0; i <= v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    @Override
    public int getVertexCount() {
        return v;
    }

    @Override
    public Iterable<Integer> getAdjList(int source) {
        return adj[source];
    }

    @Override
    public void add(int v, int w) {
        adj[v].add(w);
    }
}
