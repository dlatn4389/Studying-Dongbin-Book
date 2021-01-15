package Chapter7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem7_7 {
    public static void main(String[] args) throws IOException {
        int N, M;
        Set<Integer> store = new HashSet<>();
        String s;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i=0; i<N; i++) {
            store.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i=0; i<M; i++) {
            if (store.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
