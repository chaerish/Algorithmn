import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N = 0;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 0;
        
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) { //3,2 둘다로 나눠질 수 있기 때문에 else if 사용X
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            } if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]); //이미 dp[i]는 +1 이 된 값이므로 +1은 전 거에만 해줌 
            } 
        }
        System.out.println(dp[N]);
    }
}