package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problems {
    //1. bipartite?
    //2. find cycle
    //3. Find cycle that uses every edge exactly once
    //4. Graph isomorphism problem (no one knows efficient solution)
    //5.

    public static void print(Graph g) {
        for (int i = 0; i <= g.getVertexCount(); i++) {
            for (int val : g.getAdjList(i))
                System.out.println(i + "-->" + val);
        }
    }

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.getAdjList(v)) degree++;

        return degree;
    }

    public static int maxDegree(Graph g) {
        int maxDegree = 0;
        for (int i = 0; i <= g.getVertexCount(); i++) {
            if (degree(g, i) > maxDegree) maxDegree = degree(g, i);
        }
        return maxDegree;
    }

    public static int selfLoopCount(Graph g, boolean isDigraph) {
        int count = 0;

        for (int i = 0; i <= g.getVertexCount(); i++) {
            for (int w : g.getAdjList(i)) {
                if (i == w) count++;
            }
        }

        return isDigraph ? count : count / 2;
    }

    public static void dfs(Graph g) {
        boolean[] visited = new boolean[g.getVertexCount() + 1];
        dfs(g, visited, 1);
    }

    public static void bfs(Graph g, int source) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[g.getVertexCount() + 1];
        q.add(source);
        visited[source] = true;
        System.out.print(source + " ");

        while (!q.isEmpty()) {
            int w = q.poll();
            for (int x : g.getAdjList(w)) {
                if (!visited[x]) {
                    q.add(x);
                    System.out.print(x + " ");
                    visited[x] = true;
                }
            }
        }
    }

    public static void dfs(Graph g, boolean[] visited, int source) {
        visited[source] = true;
        System.out.println(source);
        for (int w : g.getAdjList(source)) {
            if (!visited[w]) {
                dfs(g, visited, w);
            }
        }
    }

    public static void topologicalSort(Graph g) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[g.getVertexCount() + 1];
        for (int i = 1; i <= g.getVertexCount(); i++) {
            if (!visited[i])
                dfsTopologicalSort(g, s, visited, i);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

        System.out.println();
    }

    private static void dfsTopologicalSort(Graph g, Stack<Integer> s, boolean[] visited, int source) {
        visited[source] = true;
        s.push(source);

        for (int w : g.getAdjList(source)) {
            if (!visited[w]) dfsTopologicalSort(g, s, visited, w);
        }
    }
}
