import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K = 0; //N: 물품의 수, K: 준서가 버틸 수 있는 무게
    static int[] w; //물건의 무게
    static int[] v; //물건의 가치
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        w = new int[N + 1];
        v = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 0; //dp[i][j] -> i번째 아이템을 사용하거나, 사용하지 않거나 할 때 무게 j에서 최대 가치
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }

}