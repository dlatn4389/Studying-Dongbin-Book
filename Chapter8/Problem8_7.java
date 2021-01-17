package Chapter8;

import java.util.Scanner;

public class Problem8_7 {
    static int[] boards = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boards[1] = 1;
        boards[2] = 3;
        for (int i=3; i<=N; i++) {
            boards[i] = (boards[i-1]) + (2*boards[i-2]);
        }
        System.out.println(boards[N]);
    }
}
