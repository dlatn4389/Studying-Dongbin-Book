import java.util.*;

public class Problem5_10 {
    static String[][] iceboard;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        iceboard = new String[N][M];

        for (int i=0; i<N; i++) {
            String input = sc.nextLine();
            iceboard[i] = input.split("");
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if (x<0 || y<0) {
            return false;
        }
        if (x>=iceboard.length || y>=iceboard[0].length) {
            return false;
        }
        if (iceboard[x][y].equals("0")) {
            iceboard[x][y] = "1";
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);

            return true;
        }
        return false;
    }
}
