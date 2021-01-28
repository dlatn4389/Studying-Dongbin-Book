package Chapter9;

import java.util.Scanner;

public class Problem9_4 {

    final static int INF = 99999999;

    public static void main(String[] args) {
        //Get input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int M = sc.nextInt();

        //Setting array
        int[][] distances = return2DArray(INF, N+1, N+1);
        for (int i=1; i<=N; i++) {
            distances[i][i] = 0;
        }
        for (int i=0; i<M; i++) {
            int comp1 = sc.nextInt();
            int comp2 = sc.nextInt();
            distances[comp1][comp2] = 1;
            distances[comp2][comp1] = 1;
        }
        for (int k=1; k<=N; k++) {
            for (int from=1; from<=N; from++) {
                for (int to=1; to<=N; to++) {
                    distances[from][to] = min(distances[from][to], distances[from][k]+distances[k][to]);
                }
            }
        }
        int X = sc.nextInt(); int K = sc.nextInt();
        if (distances[1][K]==INF || distances[K][X]==INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(distances[1][K]+distances[K][X]);
        }
    }

    public static int[][] return2DArray(int initializeValue, int rowSize, int columnSize) {
        int[][] array = new int[rowSize][columnSize];
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++) {
                array[i][j] = INF;
            }
        }
        return array;
    }

    public static int min(int a, int b) {
        if (a>b) return b;
        return a;
    }
}
