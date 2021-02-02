package Chapter12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompressString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        String now = null;
        int leftIndex, rightIndex;

        int length = s.length();
        List<Integer> lengths = new ArrayList<>();

        int sliceLength = 1; int same = 1;
        while (lengths.size()!=length) {
            String compressed = "";
            leftIndex = 0; rightIndex = sliceLength;

            while (true) {
                now = s.substring(leftIndex, rightIndex);
                if ((leftIndex+sliceLength<length && rightIndex+sliceLength<=length) && now.equals(s.substring(leftIndex+sliceLength, rightIndex+sliceLength))) {
                    same++;
                }
                else {
                    if (same!=1) {
                        compressed += same;
                    }
                    compressed += now;
                    same = 1;
                }
                leftIndex = rightIndex; rightIndex += sliceLength;
                if (rightIndex>length) {
                    if (leftIndex<length) {
                        compressed += s.substring(leftIndex);
                    }
                    break;
                }
            }
            lengths.add(compressed.length());
            sliceLength++;
        }
        return min(lengths);
    }

    static int min(List<Integer> list) {
        int min = 99999999;
        for (Integer i : list) {
            if (i<min) min = i;
        }
        return min;
    }
}
