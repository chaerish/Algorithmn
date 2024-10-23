import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int layer = 1; //layer은 1부터 시작한다.
		int range = 2; //범위는 2부터 시작한다. 
		// 1+6, 7+6+6 19+6+6+6
		while(N>=range) { //N이 경계값보다 작을동안만 한다.
			range += layer * 6; //
			layer++;
		}
		System.out.println(layer);
	}

}
