import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
public class Main {
	final static String Equilateral = "Equilateral";
	final static String Scalene = "Scalene";
	final static String Invalid = "Invalid";
	final static String Isosceles = "Isosceles";
	static List<String> results = new ArrayList<>();
	String line;
	
	
	private void solution() throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine())!=null && !line.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreElements()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				boolean check = checkInvaild(a,b,c);
				if(!check) {
				  setResult(a,b,c);
				}
			}
		}
		for(String result: results) {
			System.out.println(result);
		}
		br.close();
		
	}
	private boolean  checkInvaild(int a, int b, int c) {
		int max = Math.max(Math.max(a, b),c);
		if(max>=a+b+c-max) {
			results.add(Invalid);
			return true;
		}
		return false;
	}
	private static void setResult(int a, int b, int c) {
		if(a==b || b==c || a == c) {
			if(a==b && b==c) {
				results.add(Equilateral);
				return;
			}
			results.add(Isosceles);
			return;
		}
		results.add(Scalene);
	}
	
	 public static void main(String[] args) throws IOException {
	        new Main().solution();
	    }


}