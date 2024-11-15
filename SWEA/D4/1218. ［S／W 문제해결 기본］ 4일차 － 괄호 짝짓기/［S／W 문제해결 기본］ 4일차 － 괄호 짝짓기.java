import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	static Deque<Character> dq;
	public static void main(String [] args) throws NumberFormatException, IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for(int test = 1; test<=10; test++) {
		int len = Integer.parseInt(br.readLine());
		dq = new ArrayDeque<>();
		String line = br.readLine();
		for(int i =0; i<len ; i++) {
			char c = line.charAt(i);
			if(dq.isEmpty()) {
				dq.offerLast(c);
			}else {
				char last = dq.peekLast();
				if(c == '(' && last == ')' || c == ')' && last == '(') {
					dq.pollLast();
				}else if(c == '{' && last == '}' || c == '}' && last == '{') {
					dq.pollLast();
				}else if(c == '[' && last == ']' || c == ']' && last == '[') {
					dq.pollLast();
				}else if(c == '<' && last == '>' || c == '>' && last == '<') {
					dq.pollLast();
				}else {
					dq.offerLast(c);
				}
			}	
		}
		int result = 1;
		if(!dq.isEmpty()) {
			result = 0;
		}
		sb.append("#").append(test).append(" ").append(result).append("\n");
	  }
	System.out.println(sb);
	}
}