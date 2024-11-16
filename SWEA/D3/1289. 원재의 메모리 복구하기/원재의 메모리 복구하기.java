import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static String original;
	private static int answer;
	private static boolean carr [];
	private static boolean barr [];
	public static void main(String []args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test<=T; test++) {
			answer = 0;
			original =  br.readLine();
			carr = new boolean[original.length()];
			barr = new boolean[original.length()];
			
			for(int i=0; i<original.length();i++) {
				barr[i] = original.charAt(i) == '1' ;
			}
			for(int i=0; i<original.length();i++) {
				if(carr[i]!=barr[i]) {
					for(int j=i; j<original.length();j++) {
						carr[j]= barr[i];
					}
					answer++;
				}
			}
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}
