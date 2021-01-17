package Chapter8;

import java.util.Scanner;

public class Problem8_5 {
    static int[] nums = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        for (int i=0; i<30001; i++) {
            nums[i] = -1;
        }
        nums[X] = 0;
        topDown(X);
        System.out.println(nums[1]);
        for (int i=1; i<27; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void topDown(int X) {
        for (int i=X; i>0; i--) {
            System.out.println("X: " + i);
            if (X%5==0) {
                if (nums[X/5]==-1) {
                    nums[X/5] = nums[X]+1;
                }
                else if (nums[X/5]>nums[X]+1) {
                    nums[X/5] = nums[X]+1;
                }
            }
            if (X%3==0) {
                if (nums[X/3]==-1) {
                    nums[X/3] = nums[X]+1;
                }
                else if (nums[X/3]>nums[X]+1) {
                    nums[X/3] = nums[X]+1;
                }
            }
            if (X%2==0) {
                if (nums[X/2]==-1) {
                    nums[X/2] = nums[X]+1;
                }
                else if (nums[X/2]>nums[X]+1) {
                    nums[X/2] = nums[X]+1;
                }
            }
            if (nums[X-1]==-1) {
                nums[X-1] = nums[X]+1;
            }
            else if (nums[X-1]>nums[X]+1) {
                nums[X-1] = nums[X]+1;
            }
            X -= 1;
        }
    }
}
