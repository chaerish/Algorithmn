import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr [];
	static int N;
	static int M;
	static int [] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N];
		answer = new int [M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		recursive(0,0);
		System.out.println(sb);	
	}
	private static void recursive(int depth, int p) {
		if(depth == M) {
			for(int j=0; j<M; j++) {
				sb.append(answer[j]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i= p;i<N; i++) {
			answer[depth] = arr[i];
			recursive(depth+1,i+1);
		}	
	}
}
