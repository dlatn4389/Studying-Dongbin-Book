package Chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Problem6_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i=0; i<T; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i=T-1; i>=0; i--) {
            System.out.println(nums[i]);
        }
    }
}
