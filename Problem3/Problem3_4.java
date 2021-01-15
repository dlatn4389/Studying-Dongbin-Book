package Problem3;

import java.util.Scanner;

public class Problem3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputInts = sc.nextLine();
        String[] inputInt = inputInts.split(" ");
        int N, K;
        N = Integer.parseInt(inputInt[0]);
        K = Integer.parseInt(inputInt[1]);

        int answer = 0;
        while (N!=1) {
            if (N%K==0) {
                N /= K;
            }
            else {
                N -= 1;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
