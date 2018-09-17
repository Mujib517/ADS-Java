package graph;

public interface Graph {

    int getVertexCount();

    void add(int v, int w);

    Iterable<Integer> getAdjList(int source);
}
