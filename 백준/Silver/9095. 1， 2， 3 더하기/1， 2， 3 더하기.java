import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, T;
    static int[] dp = new int[12];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int n = 4; n <= N; n++) {
                dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}