package Chapter8;

import java.util.Scanner;

public class Problem8_8 {
    static int[] price = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] money = new int[N];
        for (int i=0; i<N; i++) {
            money[i] = sc.nextInt();
        }
        for (int i=0; i<=M; i++) {
            price[i] = -1;
        }
        price[M] = 0;
        for (int i : money) {
            for (int j=M; j>=0; j--) {
                if (price[j]!=-1) {
                    if (j-i>=0) {
                        if (price[j-i]==-1) {
                            price[j-i] = price[j]+1;
                        }
                        else if (price[j-i]>price[j]+1) {
                            price[j-i] = price[j]+1;
                        }
                    }
                }
            }
        }
        System.out.println(price[0]);
    }
}
