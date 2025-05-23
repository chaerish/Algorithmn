import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr [][];
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int [N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0],o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		int count = 0;
		int last = 0;
		for(int i=0; i<N;i++) {
			if(arr[i][0]>=last) {
				last = arr[i][1];
				count ++;
			}
		}
		System.out.println(count);	
	}
}