package graph;

import heaps.PQ;

import java.util.*;

public class ShortestPath {
    public void Dijkistra(Graph g, int source) {
        int current = source;
        PQ minHeap = new PQ(g.getVertexCount());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < g.getVertexCount(); i++) {
            Edge e = new Edge(i, source == i ? 0 : Integer.MAX_VALUE);
            minHeap.add(e);
        }

        while (!minHeap.isEmpty()) {
            Edge min = minHeap.poll();
            current = min.id;
            map.put(min.id, min.weight);

            for (int w : g.getAdjList(current)) {
                if (minHeap.contains(w)) minHeap.decrease(w, min.weight);
            }
        }
    }

}
