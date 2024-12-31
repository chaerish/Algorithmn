import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
    static int N, K, count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        while (K > 0) {
            for (Integer coin : set) {
                if (K >= coin) {
                    int remain = K / coin;
                    count += remain;
                    K -= remain * coin;
                }
            }
        }
        System.out.println(count);
    }
}