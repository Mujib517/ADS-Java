package graph;

public class ConnectedComponent {

    private UndirectedGraph g;
    private int[] cc;

    public ConnectedComponent(UndirectedGraph g) {
        this.g = g;
        cc = new int[g.v + 1];
        build();
    }

    private void build() {
        int count = 0;
        boolean[] visited = new boolean[g.v + 1];

        for (int i = 1; i <= g.v; i++) {
            if (!visited[i]) {
                dfs(i, visited, count);
                count++;
            }
        }

    }

    private void dfs(int source, boolean[] visited, int count) {
        visited[source] = true;
        cc[source] = count;
        for (int w : g.adjMatrix[source]) {
            if (!visited[w]) dfs(w, visited, count);
        }
    }

    public boolean areConnected(int x, int y) {
        return cc[x] == cc[y];
    }
}
