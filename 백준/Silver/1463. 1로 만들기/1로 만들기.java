import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /*
     1. X가 3으로 나눠떨어지면 3으로 나눔.
     2. X가 2으로 나눠 떨어지면, 2로 나눔,
     3 1를 뺀다.
     */
    static int N, count;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1]; //dp[i] = i일때 최소 연산 숫자.
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
