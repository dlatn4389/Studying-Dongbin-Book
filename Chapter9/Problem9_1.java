package Chapter9;

import java.util.*;

public class Problem9_1 {
    final static int INF = 99999999;

    public static void main(String[] args) {
        //GET INPUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int start = sc.nextInt();

        //Setting Arrays
        int[] distance = returnArray(INF, n+1);
        boolean[] visited = returnArray(false, n+1);
        List<List<NodeAndCost<Integer, Integer>>> graph = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=1; i<m+1; i++) {
            int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
            graph.get(a).add(new NodeAndCost<>(b, c));
        }

        dijkstra(start, graph, distance, visited);

        for (int dist : distance) {
            if (dist==INF) {
                System.out.println("INFINITY");
            }
            else {
                System.out.println(dist);
            }
        }
    }

    public static int get_smallest_node(int[] distance, boolean[] visited) {
        int min = INF;
        int index = 0;
        for (int i=1; i<distance.length; i++) {
            if (!visited[i] && min>distance[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start, List<List<NodeAndCost<Integer, Integer>>> graph, int[] distance, boolean[] visited) {
        distance[start] = 0;
        visited[start] = true;
        for (NodeAndCost x : graph.get(start)) {
            distance[(int)x.node] = (int)x.cost;
        }
        for (int i=1; i<distance.length-1; i++) {
            int now = get_smallest_node(distance, visited);
            visited[now] = true;
            for (NodeAndCost x : graph.get(now)) {
                int cost = distance[now] + (int)x.cost;
                if (cost<distance[(int)x.node]) {
                    distance[(int)x.node] = cost;
                }
            }
        }
    }

    public static int[] returnArray(int initializeValue, int length) {
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = initializeValue;
        }
        return array;
    }

    public static boolean[] returnArray(boolean initializeValue, int length) {
        boolean[] array = new boolean[length];
        for (int i=0; i<length; i++) {
            array[i] = initializeValue;
        }
        return array;
    }
}
