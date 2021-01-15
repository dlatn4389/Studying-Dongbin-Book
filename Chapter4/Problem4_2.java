package Chapter4;

import java.util.Scanner;

public class Problem4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 0;
        for (int hour=0; hour<N+1; hour++) {
            for (int min=0; min<60; min++) {
                for (int sec=0; sec<60; sec++) {
                    if (hour%10==3) {
                        answer++;
                    }
                    else if (min%10==3 || min/10==3) {
                        answer++;
                    }
                    else if (sec%10==3 || sec/10==3) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
