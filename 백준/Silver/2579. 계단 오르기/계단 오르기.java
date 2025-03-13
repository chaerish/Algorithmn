import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(arr[N]);
            return;
        }
        if (N == 2) {
            System.out.println(arr[N - 1] + arr[N]);
            return;
        }
        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++) { // 현재 입장에서 전에 O X or X O 만 보면 됨.
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }
        System.out.println(dp[N]);
    }
}
