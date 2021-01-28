package Chapter9;

import java.util.Scanner;

public class Problem9_3 {

    final static int INF = 99999999;

    public static void main(String[] args) {
        //Get input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();

        int distance[][] = return2DArray(INF, n+1, n+1);

        for (int i=0; i<m; i++) {
            int fromNode = sc.nextInt();
            int toNode = sc.nextInt();
            int cost = sc.nextInt();

            distance[fromNode][toNode] = cost;
        }
        for (int i=1; i<=n; i++) {
            distance[i][i] = 0;
        }

        for (int k=1; k<=n; k++) {
            for (int fromNode=1; fromNode<=n; fromNode++) {
                for (int toNode=1; toNode<=n; toNode++) {
                    distance[fromNode][toNode] = min(distance[fromNode][toNode], distance[fromNode][k]+distance[k][toNode]);
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int min(int a, int b) {
        if (a>b) return b;
        return a;
    }

    public static int[][] return2DArray(int initializeValue, int rowSize, int columnSize) {
        int[][] array = new int[rowSize][columnSize];
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++) {
                array[i][j] = initializeValue;
            }
        }
        return array;
    }
}
