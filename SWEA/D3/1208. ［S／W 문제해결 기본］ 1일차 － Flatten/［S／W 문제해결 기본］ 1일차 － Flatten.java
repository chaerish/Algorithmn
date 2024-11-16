import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int [] nums;
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test =1; test<=10; test++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[100];
			for(int i=0; i<100; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			int min = 0;
			while(dump-->0) {
				Arrays.sort(nums);
				nums[99] = nums[99]-1;
				nums[0] = nums[0]+1;
				
			}
			Arrays.sort(nums);
			max = nums[99];
			min = nums[0];
			sb.append("#").append(test).append(" ").append(max - min).append("\n");	
		}
		System.out.println(sb);
	}
}