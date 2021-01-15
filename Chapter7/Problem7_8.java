package Chapter7;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem7_8 {
    public static void main(String[] args) {
        int N, M;
        int[] ricecakes;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        ricecakes = new int[N];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i=0; i<N; i++) {
            ricecakes[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end =  max(ricecakes);

        int total;
        int result=0;

        while (start<=end) {
            total = 0;
            int mid = (start+end)/2;

            for (int i : ricecakes) {
                if (i>mid) {
                    total += (i-mid);
                }
            }
            if (total<M) {
                end = mid-1;
            }
            else {
                result = mid;
                start = mid+1;
            }
        }

        System.out.println(result);
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i]>max) {
                max = array[i];
            }
        }
        return max;
    }
}
