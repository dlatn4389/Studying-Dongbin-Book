package Chapter9;

import org.w3c.dom.Node;

import java.util.*;

public class Problem9_2 {
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
        for (int i=0; i<m; i++) {
            int fromNode = sc.nextInt();
            int toNode = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(fromNode).add(new NodeAndCost<>(toNode, cost));
        }

        dijkstra(start, graph, distance, visited);

        //print Arrays
        for (int i=1; i<n+1; i++) {
            if (distance[i]==INF) {
                System.out.println("INFINITY");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start, List<List<NodeAndCost<Integer, Integer>>> graph, int[] distance, boolean[] visited) {
        // start point
        distance[start] = 0;
        visited[start] = true;

        // Set priorityQueue
        PriorityQueue<NodeAndCost<Integer, Integer>> priorityQueue = new PriorityQueue<>();
        for (NodeAndCost<Integer, Integer> i : graph.get(start)) {
            distance[i.node] = i.cost;
            priorityQueue.add(new NodeAndCost<>(i.node, i.cost));
        }

        while (!priorityQueue.isEmpty()) {
            NodeAndCost<Integer, Integer> least = priorityQueue.poll();
            int dist = least.cost;
            int now = least.node;
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
