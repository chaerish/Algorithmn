
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
	static HashMap<Character,Integer> count = new HashMap<>();
	public static void main(String [] args) throws NumberFormatException, IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for(int test = 1; test<=10; test++) {
		int len = Integer.parseInt(br.readLine());
		char [] charArr = br.readLine().toCharArray();
		count.put('(', 0);
		count.put(')', 0);
		count.put('[', 0);
		count.put(']', 0);
		count.put('{', 0);
		count.put('}', 0);
		count.put('<', 0);
		count.put('>', 0);
		for(int i = 0; i<charArr.length; i++) {
			char c = charArr[i];
			int num = count.get(c);
			count.put(c, num+1);
		}
		int result = 1;
		if(!count.get('(').equals(count.get(')'))||!count.get('[').equals(count.get(']')) || !count.get('{').equals(count.get('}')) ||!count.get('<').equals(count.get('>'))) {
			result = 0;
		}
		sb.append("#").append(test).append(" ").append(result).append("\n");
	}
	System.out.println(sb);
	}
}