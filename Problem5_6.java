public class Problem5_6 {
    static final int INF = 99999999;
    static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
