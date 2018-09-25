package graph;

import java.util.*;

public class ShortestPath {

    class Edge {
        public int id;
        public int weight;

        public Edge(int id, int weight) {
            this.id = id;
            this.weight = this.weight;
        }
    }

    class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.weight < o2.weight) return -1;
            return 1;
        }
    }

    public void Dijkistra(Graph g, int source) {
        int current = source;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(new EdgeComparator());
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < g.getVertexCount(); i++) {
            Edge e = new Edge(i, source == i ? 0 : Integer.MAX_VALUE);
            minHeap.add(e);
            set.add(i);
        }

        while (!minHeap.isEmpty()) {
            Edge min = minHeap.poll();
            current = min.id;
            set.remove(current);

            for (int w : g.getAdjList(current)) {
                if (set.contains(w)) {

                }
            }
        }
    }

}
