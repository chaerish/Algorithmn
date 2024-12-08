import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main { 
	static Stack<Character> stack = new Stack<>();
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] arr = br.readLine().toCharArray();
		String bomb = br.readLine();
		for(int i=0; i<arr.length;i++) {
			stack.push(arr[i]); //스택에 집어넣는다.
			if(stack.size() >= bomb.length()) { //제거해야하는 길이와 동일해지면 
				boolean flag = true;
				for(int j=0;j<bomb.length();j++) {
					if(stack.get((stack.size()-bomb.length())+j) != bomb.charAt(j)) {
						flag = false;
					}
				}
				if(flag) { 
					for(int j=0; j<bomb.length(); j++) {
						stack.pop();
					}
				}
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(char c: stack) {
			sb.append(c);
		}
		String str = sb.toString() == "" ? "FRULA" : sb.toString();
		System.out.println(str);
	}
}