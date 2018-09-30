package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphCycleProblem {

    public static boolean hasCycleDigraph(DiGraph g) {
        Set<Integer> white = new HashSet<>();
        Set<Integer> gray = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= g.getVertexCount(); i++) white.add(i);

        while (!white.isEmpty()) {
            int current = white.iterator().next();
            if (!map.containsKey(current)) map.put(current, null);
            if (dfs(g, current, white, gray, black, map)) return true;
        }

        return false;
    }

    private static String findPath(int current, Map<Integer, Integer> map) {
        String path = current + " -> ";

        while (!map.isEmpty()) {
            Integer ct = map.get(current);
            if (ct == null) return path;
            path += ct + " -> ";
            current = ct;
        }

        return path;
    }

    private static boolean dfs(DiGraph g, int current, Set<Integer> white, Set<Integer> gray, Set<Integer> black, Map<Integer, Integer> map) {
        move(current, white, gray);

        for (int v : g.getAdjList(current)) {
            if (black.contains(v)) continue;
            if (gray.contains(v)) {
                return true;
            }
            if (!map.containsKey(v)) map.put(v, current);
            if (dfs(g, v, white, gray, black, map)) return true;
        }
        move(current, gray, black);
        return false;
    }

    private static void move(int val, Set<Integer> source, Set<Integer> dest) {
        source.remove(val);
        dest.add(val);
    }
}


