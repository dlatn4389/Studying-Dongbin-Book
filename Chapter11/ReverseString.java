package Chapter11;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int length = input.length();

        printer(input, length);
    }

    public static int min(int a, int b) {
        if (a>b) return b;
        return a;
    }

    static void printer(String input, int length) {
        if (length==1) {
            System.out.println(0);
            return;
        }
        else if (length==2) {
            if (input.charAt(0)!=input.charAt(1)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
            return;
        }
        boolean series = false;
        int zeroSeries = 0, oneSeries = 0;
        for (int i=0; i<length-1; i++) {
            if (!series && input.charAt(i)==input.charAt(i+1)) {
                if (input.charAt(i)=='0') {
                    zeroSeries++;
                }
                else {
                    oneSeries++;
                }
                series = true;
            }
            else if (series && input.charAt(i)!=input.charAt(i+1)) {
                series = false;
            }
        }
        for (int i=1; i<length-1; i++) {
            if (input.charAt(i)!=input.charAt(i-1)&&input.charAt(i)!=input.charAt(i+1)) {
                if (input.charAt(i)=='0') {
                    zeroSeries++;
                }
                else {
                    oneSeries++;
                }
            }
        }
        if (input.charAt(0)!=input.charAt(1)) {
            if (input.charAt(0)=='0') {
                zeroSeries++;
            }
            else {
                oneSeries++;
            }
        }
        if (input.charAt(length-1)!=input.charAt(length-2)) {
            if (input.charAt(length-1)=='0') {
                zeroSeries++;
            }
            else {
                oneSeries++;
            }
        }

        System.out.println(min(zeroSeries, oneSeries));
    }
}
