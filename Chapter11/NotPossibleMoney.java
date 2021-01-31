package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class NotPossibleMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] coins = new int[N];
        for (int i=0; i<N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        for (int money=1; money<=1000000000; money++) {
            if (!canMake(money, coins)) {
                System.out.println(money);
                break;
            }
        }
    }

    static boolean canMake(int money, int[] coins) {
        int N = coins.length;
        for (int i=0; i<N; i++) {
            int nMoney = money;
            for (int j=i; j<N; j++) {
                nMoney -= coins[j];
                if (nMoney==0) return true;
            }
        }
        return false;
    }
}
