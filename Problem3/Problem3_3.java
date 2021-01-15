package Problem3;

import java.util.Scanner;

public class Problem3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputInts = sc.nextLine();
        String[] inputInt = inputInts.split(" ");
        int N, M;
        N = Integer.parseInt(inputInt[0]);
        M = Integer.parseInt(inputInt[1]);

        String inputArray;
        String[] inputRow_String;
        int[] mins = new int[N];
        int min;

        for (int row=0; row<N; row++) {
            inputArray = sc.nextLine();
            inputRow_String = inputArray.split(" ");
            min = Integer.parseInt(inputRow_String[0]);
            for (int column=1; column<M; column++) {
                if (Integer.parseInt(inputRow_String[column]) < min) {
                    min = Integer.parseInt(inputRow_String[column]);
                }
            }
            mins[row] = min;
        }

        int result = mins[0];
        for (int i=1; i<N; i++) {
            if (mins[i]>result) {
                result = mins[i];
            }
        }
        System.out.println(result);
    }
}
