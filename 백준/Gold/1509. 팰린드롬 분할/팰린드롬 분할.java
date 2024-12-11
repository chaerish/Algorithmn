import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] isPalin;
	static int dp [];
	static String str ="";
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int N = str.length();
		isPalin = new boolean[N][N];
		dp = new int [N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		for(int i=0; i<N;i++) {
			for(int j=i+1; j<N;j++) {
				boolean is = check(i,j); 
				isPalin[i][j] = is;
			}
		}
	
		for(int i=2; i<=N; i++){
			dp[i] = dp[i-1] + 1;
		    for(int j=0; j<i; j++){
				if(isPalin[j][i-1]){
					dp[i] = Math.min(dp[i],  dp[j]+1);
				}
		    }
		}
		System.out.println(dp[N]);
	}
	private static boolean check(int l, int r) {
		while(l<r) {
			if(str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;	
	}
}
