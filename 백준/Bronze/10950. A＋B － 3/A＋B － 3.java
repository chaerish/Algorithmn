import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		for(int i = 0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hap = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
			System.out.println(hap);
		}	
	}

}
