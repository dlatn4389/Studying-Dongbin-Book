package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class BallingBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int M = sc.nextInt();
        int balls[] = new int[N];

        for (int i=0; i<N; i++) {
            balls[i] = sc.nextInt();
        }
        Arrays.sort(balls);

        int answer = 0;
        for (int i=1; i<=M; i++) {
            int index = getIndex(balls, i);
            if (index!=-1) {
                int num = 0; int differentWeight = 0;
                for (int j=index; j<N; j++) {
                    if (balls[j]!=i) {
                        differentWeight++;
                    }
                    else {
                        num++;
                    }
                }
                answer += num*differentWeight;
            }
        }
        System.out.println(answer);
    }

    static int getIndex(int[] balls, int i) {
        for (int k=0; k<balls.length; k++) {
            if (balls[k]==i) {
                return k;
            }
        }
        return -1;
    }
}
