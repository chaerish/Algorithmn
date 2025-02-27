import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    static int N = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        dp = new long[N + 1];
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        System.out.println(dp[N]);
    }
}
