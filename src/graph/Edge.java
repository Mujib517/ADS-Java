package graph;

public class Edge implements Comparable {
    public int id;
    public int weight;

    public Edge(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        Edge edge = (Edge) obj;
        return this.id == edge.id;
    }

    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        if (this.weight < edge.weight) return -1;
        else if (this.weight == edge.weight) return 0;
        return 1;
    }
}