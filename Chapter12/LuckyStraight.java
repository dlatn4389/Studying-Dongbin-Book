package Chapter12;

import java.util.Scanner;

public class LuckyStraight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int length = input.length();

        int leftSum = 0, rightSum = 0;
        for (int i=0; i<length; i++) {
            if (i<length/2) {
                leftSum += input.charAt(i)-'0';
            }
            else {
                rightSum += input.charAt(i)-'0';
            }
        }

        if (leftSum==rightSum) {
            System.out.println("LUCKY");
        }
        else {
            System.out.println("READY");
        }
    }
}
