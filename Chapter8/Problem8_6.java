package Chapter8;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem8_6 {
    static int[] most = new int[101];
    static int[] stores;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        stores = new int[N];
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        for (int i=0; i<N; i++) {
            stores[i] = Integer.parseInt(st.nextToken());
        }

        most[0] = stores[0];
        most[1] = max(stores[0], stores[1]);

        for (int i=2; i<N; i++) {
            most[i] = max(most[i-1], most[i-2]+stores[i]);
        }
        System.out.println(most[N-1]);
    }

    static int max(int a, int b) {
        if (a>b) {
            return a;
        }
        return b;
    }
}
