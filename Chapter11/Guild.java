package Chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class Guild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int scares[] = new int[n];

        for (int i=0; i<n; i++) {
            scares[i] = sc.nextInt();
        }
        Arrays.sort(scares);

        int answer = 0;
        for (int i=0; i<n; i++) {
            if (scares[i]==1) {
                scares[i] = 0;
                answer++;
            }
            else {
                break;
            }
        }

        int index = n-1;
        while (true) {
            if (scares[index]==0) {
                break;
            }
            int newIndex = index-scares[index]+1;
            if (newIndex<0 || scares[newIndex]==0) {
                break;
            }
            answer++;
            index = newIndex-1;
            if (index<0) {
                break;
            }
        }
        System.out.println(answer);
    }
}
