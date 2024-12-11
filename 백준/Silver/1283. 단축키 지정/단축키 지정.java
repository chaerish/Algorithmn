import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	static Set<Character> usedKeys;
	static List<String> sarr;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		usedKeys = new HashSet<>();
		sarr = new ArrayList<>();
		for(int i=0; i<N;i++) {
			String str = br.readLine();
			sarr.add(str);
		}
		for(String line: sarr) { //문장을 돌면서
			String [] split = line.split(" ");
			boolean flag = false;
			for(int i=0; i<split.length;i++) {
				String word = split[i];
				char firstChar = split[i].charAt(0);
				if(!usedKeys.contains(firstChar)) {
					usedKeys.add(Character.toUpperCase(firstChar));
					usedKeys.add(Character.toLowerCase(firstChar));
					String old = split[i];
					String newStr = "[" + word.charAt(0) + "]" + word.substring(1,word.length());
					line = line.replaceFirst(old,newStr);
					flag = true;
					break;
				}
			}
		
			if(!flag) {
				char [] chars = line.toCharArray();
				for(int j=0; j<chars.length; j++) {
					char firstChar = chars[j];
					if(firstChar!=' ' &&!usedKeys.contains(firstChar)) {
						usedKeys.add(Character.toUpperCase(firstChar));
						usedKeys.add(Character.toLowerCase(firstChar));
						line = line.substring(0,j) + "[" + firstChar + "]" + line.substring(j+1,line.length());
						flag = true;
						break;
					}
				}
				flag = true;
			}
			sb.append(line).append("\n");
		}
		System.out.println(sb);	
	}
}
