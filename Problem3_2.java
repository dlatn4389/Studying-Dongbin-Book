import java.util.Scanner;

public class Problem3_2 {
    public static void main(String[] args) {
        //get Input
        Scanner sc = new Scanner(System.in);
        String numInputs = sc.nextLine();
        String[] numInput = numInputs.split(" ");
        int N, M, K;
        N = Integer.parseInt(numInput[0]);
        M = Integer.parseInt(numInput[1]);
        K = Integer.parseInt(numInput[2]);

        String arrayInputs = sc.nextLine();
        String[] arrayInput = arrayInputs.split(" ");
        int[] array = new int[N];
        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(arrayInput[i]);
        }

        int maxInt = 0;
        int maxCount = 1;
        int secondMaxInt = 0;

        for (int i=0; i<N; i++) {
            if (array[i]>maxInt) {
                maxInt = array[i];
                maxCount = 1;
            }
            else if (array[i]==maxInt) {
                maxCount++;
            }
        }
        for (int i=0; i<N; i++) {
            if (array[i]!=maxInt && array[i]>secondMaxInt) {
                secondMaxInt = array[i];
            }
        }

        int result = 0;

        if (maxCount==1) {
            int count = 0;
            while (count!=M) {
                count++;
                if (count%K==0) {
                    result += secondMaxInt;
                    continue;
                }
                result += maxInt;
            }
        }
        else {
            result += M*maxInt;
        }
        System.out.println(result);
    }
}
