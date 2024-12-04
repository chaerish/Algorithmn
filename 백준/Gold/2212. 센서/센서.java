import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int s[];
	static int minus[];
	public static void main(String []args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = new int [N];
		minus = new int [N-1];
		for(int i=0; i<s.length;i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(s);
		for(int i=0; i<minus.length;i++) {
			minus[i] = s[i+1] - s[i];
		}
		Arrays.sort(minus);
		int answer = 0;
		for(int i=0; i<N-K;i++) {
			answer+=minus[i];
		}
		System.out.println(answer);
	}
}