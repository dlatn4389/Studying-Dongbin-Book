package Chapter11;

import java.util.Scanner;

public class MulorPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int answer = 0; char zerochar = '0'; int zero = zerochar;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            int num = c; num -= zero;
            if (num==0||num==1) {
                answer += num;
            }
            else {
                if (answer==0 || answer==1) {
                    answer += num;
                }
                else {
                    answer *= num;
                }
            }
        }
        System.out.println(answer);
    }
}
