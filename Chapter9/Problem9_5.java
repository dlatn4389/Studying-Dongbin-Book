package Chapter9;

import java.util.*;

public class Problem9_5 {

    final static int INF = 99999999;

    public static void main(String[] args) {
        //Get input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt(); // starting point

        //Setting arrays
        int[] distance = returnArray(INF, N+1);
        boolean[] visited = returnArray(false, N+1);
        List<List<NodeAndCost<Integer, Integer>>> graph = new ArrayList<>();
        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();
            graph.get(X).add(new NodeAndCost<>(Y, Z));
        }
        dijkstra(C, graph, distance, visited);

        int maxDistance = 0;
        int city_receiveMessage = 0;
        for (int i=1; i<N+1; i++) {
            if (distance[i]!=INF) {
                maxDistance = max(maxDistance, distance[i]);
                city_receiveMessage++;
            }
        }
        city_receiveMessage--;
        System.out.println(city_receiveMessage + " " + maxDistance);
    }

    public static void dijkstra(int start, List<List<NodeAndCost<Integer, Integer>>> graph, int[] distance, boolean[] visited) {
        PriorityQueue<NodeAndCost<Integer, Integer>> priorityQueue = new PriorityQueue<>();
        distance[start] = 0;
        visited[start] = true;

        for (NodeAndCost<Integer, Integer> i : graph.get(start)) {
            distance[i.node] = i.cost;
            priorityQueue.add(new NodeAndCost<>(i.node, i.cost));
        }

        while (!priorityQueue.isEmpty()) {
            NodeAndCost<Integer, Integer> n = priorityQueue.poll();
            int now = n.node; int dist = n.cost;
            if (visited[now]) {
                continue;
            }
            for (NodeAndCost<Integer, Integer> e : graph.get(now)) {
                int cost = dist + e.cost;
                if (cost<distance[e.node]) {
                    distance[e.node] = cost;
                    priorityQueue.add(new NodeAndCost<>(e.node, cost));
                }
            }
        }
    }

    public static int[] returnArray(int initializeValue, int size) {
        int[] array = new int[size];
        for (int i=0; i<size; i++) {
            array[i] = initializeValue;
        }
        return array;
    }

    public static boolean[] returnArray(boolean initializeValue, int size) {
        boolean[] array = new boolean[size];
        for (int i=0; i<size; i++) {
            array[i] = initializeValue;
        }
        return array;
    }

    public static int max(int a, int b) {
        if (a>b) return a;
        return b;
    }
}
