import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem5_11 {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] temp = sc.nextLine().split("");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int x = p.k;
            int y = p.v;

            if (isRoute(x-1, y)) {
                map[x-1][y] = map[x][y]+1;
                queue.add(new Pair(x-1, y));
            }
            if (isRoute(x+1, y)) {
                map[x+1][y] = map[x][y]+1;
                queue.add(new Pair(x+1, y));
            }
            if (isRoute(x, y-1)) {
                map[x][y-1] = map[x][y]+1;
                queue.add(new Pair(x, y-1));
            }
            if (isRoute(x, y+1)) {
                map[x][y+1] = map[x][y]+1;
                queue.add(new Pair(x, y+1));
            }
        }
        /*for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.println(map[N-1][M-1]);
    }

    public static boolean isRoute(int x, int y) {
        if (x<0 || y<0) {
            return false;
        }
        if (x>=map.length || y>=map[0].length) {
            return false;
        }
        if (map[x][y]==1) {
            return true;
        }
        return false;
    }
}

class Pair<K, V> {
    K k;
    V v;
    Pair(K k, V v) {
        this.k = k; this.v = v;
    }
}