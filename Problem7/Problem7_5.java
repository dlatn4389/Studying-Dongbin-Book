package Problem7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] item = new int[N];
        for (int i=0; i<N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        s = br.readLine();
        int M = Integer.parseInt(s);
        s = br.readLine();
        st = new StringTokenizer(s);

        int[] order = new int[M];
        for (int i=0; i<M; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(item);
        searchOrder(item, order);
    }

    public static void searchOrder(int[] item, int[] order) {
        for (int i : order) {
            if (!binarySearch(item, i, 0, item.length-1)) {
                System.out.println("no");
            }
            else {
                System.out.println("yes");
            }
        }
    }

    public static boolean binarySearch(int[] item, int target, int start, int end) {
        if (start>end) {
            return false;
        }
        int mid = (start+end)/2;
        if (item[mid]>target) {
            return binarySearch(item, target, start, mid-1);
        }
        else if (item[mid]<target) {
            return binarySearch(item, target, mid+1, end);
        }
        else {
            return true;
        }
    }
}
