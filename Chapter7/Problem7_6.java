package Chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7_6 {
    public static void main(String[] args) throws IOException {
        int N, M;
        int[] items = new int[1000001];
        int[] order;
        String s;
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        N = Integer.parseInt(s);
        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i=0; i<N; i++) {
            items[Integer.parseInt(st.nextToken())] = 1;
        }
        s = br.readLine();
        M = Integer.parseInt(s);
        order = new int[M];
        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i=0; i<M; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : order) {
            if (items[i]==1) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
