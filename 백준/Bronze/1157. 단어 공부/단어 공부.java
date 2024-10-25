import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	private static HashMap<Character,Integer> numbers = new HashMap<Character,Integer>();
	private static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = word.toUpperCase();
		for(int i =0; i<word.length();i++) {
			char c = word.charAt(i);
			if(numbers.containsKey(c)){
				numbers.put(c, numbers.get(c)+1);
				continue;
			}
			numbers.put(c, 1);		
		}
		Integer maxValue = Collections.max(numbers.values());
		Character maxKey = null;
		for(Character key: numbers.keySet()) {
			if(maxKey == null || numbers.get(key)>numbers.get(maxKey)) {
				maxKey = key;
			}
			if(numbers.get(key).equals(maxValue) && !key.equals(maxKey)) {
				System.out.println("?");
				return;
			}
		}
		System.out.println(maxKey);
		
		
	}
	public static void main(String[]args) throws IOException  {
		Main.solution();
	}

}
