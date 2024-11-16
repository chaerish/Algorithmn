import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
	static String NOT = "impossible";
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test = 1; test<=N; test++) {
			int num = Integer.parseInt(br.readLine());
		    if(num%3==0) {
				for(int i=0; i<num/3;i++) {
					sb.append("AAB");
				}
			}else if(num>=2 &&num%3==2) {
                 sb.append("AB");
				for(int i=0; i<num/3;i++) {
					sb.append("AAB");
				}
			}else {
				sb.append(NOT);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}