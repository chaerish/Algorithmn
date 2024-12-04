import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String line;
	static String regex;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		regex = br.readLine();
		int answer = 0;
		int length = regex.length();
		int total = line.length();
		int i = 0;
		while(true) {
			if(total - i <length) {
				break;
			}
			String s = line.substring(i,i+length);
			if(s.matches(regex)) {
				answer++;
				i+=length;
			}else {
				i++;
			}
		}
		System.out.println(answer);	
	}
}
