package Chapter5;

import java.util.*;

public class Problem5_9 {
    static int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {6, 8},
            {1, 7}
    };

    public static void main(String[] args) {
        boolean[] visited = new boolean[9];
        for (int i=0; i<9; i++) {
            visited[i] = false;
        }
        bfs(graph, 1, visited);
        System.out.println();
        for (boolean b : visited) {
            System.out.print(b + " ");
        }
    }

    public static void bfs(int[][] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i + " ");

            for (int j : graph[i]) {
                if (!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
