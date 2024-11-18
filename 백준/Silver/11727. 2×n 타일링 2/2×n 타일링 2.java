import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
		long dp [] = new long[N];
		dp[0] = 1; //N=1일때 1개
		dp[1] = 3;
		for(int i=2;i<N;i++) {
			dp[i] = (dp[i-1]+ 2*dp[i-2])%10007;
		}
		System.out.println(dp[N-1]);
	}
}
