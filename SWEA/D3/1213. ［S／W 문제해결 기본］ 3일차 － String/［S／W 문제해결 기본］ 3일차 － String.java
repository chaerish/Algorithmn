import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test =1; test<=10;test++) {
			int N = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String context = br.readLine();
			int len = find.length();
			int count = 0;
			for(int i=0; i<context.length()-len+1; i++) {
				if(context.substring(i,i+len).equals(find)) {
					count ++;
				}
			}
			sb.append("#").append(N).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}