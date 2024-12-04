import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	static List<String> arr = new ArrayList<>();
	static String regex = "[aeiouAEIOU]";
	public static void main(String []args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile(regex);
		while(true) {
			String line = br.readLine();
			if(line.equals("#")) break;
			Matcher matcher = pattern.matcher(line);
			int count = 0;
			while(matcher.find()) {
				count++;
			}
			sb.append(count).append("\n");
			
		}
		System.out.println(sb);
	}
}