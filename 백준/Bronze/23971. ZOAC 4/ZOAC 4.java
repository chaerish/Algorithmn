import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int row = (H+N)/(N+1);
        int column = (W+M)/(M+1);
       

		System.out.println(row*column);
		
	}
	
	
	 public static void main(String[] args) throws IOException {
	        new Main().solution();
	  }
	

}