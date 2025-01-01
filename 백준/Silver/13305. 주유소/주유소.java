import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0L;
    static long oil[];
    static long money[];
    static long MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        oil = new long[N - 1];
        money = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            MIN = Math.min(MIN, money[i]);
            answer += MIN * oil[i];
        }
        System.out.println(answer);
    }
}
