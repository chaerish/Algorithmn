import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static int [][] nums;
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int test =1; test<=N; test++) {
			int len = Integer.parseInt(br.readLine());
			nums = new int[len][len];
			for(int i = 0; i<len;i++) {
				 String number = br.readLine();
				for(int j=0; j<len;j++) {
					nums[i][j] = number.charAt(j) - '0';
				}
			}
			int start = len / 2;
			int end = len/2;
			
			int sum = 0;
			for(int i=0; i<len; i++) {
				for(int j=start; j<=end; j++) {
					sum += nums[i][j];
				}
				if( i < len/2) {
					start -= 1;
					end+=1;
				}else {
					start+=1;
					end-=1;
				}
			}
			sb.append("#").append(test).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
