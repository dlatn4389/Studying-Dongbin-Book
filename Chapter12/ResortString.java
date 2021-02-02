package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class ResortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] chars = new char[input.length()];
        int intNum = 0; int sum = 0;
        for (int i=0; i<input.length(); i++) {
            chars[i] = input.charAt(i);
            if (input.charAt(i)-'0'>=0 && input.charAt(i)-'0'<=9) {
                intNum++;
                sum += input.charAt(i)-'0';
            }
        }
        Arrays.sort(chars);

        for (int i=intNum; i<chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.print(sum);
    }
}
