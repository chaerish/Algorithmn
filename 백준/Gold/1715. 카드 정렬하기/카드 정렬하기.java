import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		long answer=0;
		for(int i=0; i<N-1; i++) {
			Integer a = pq.poll();
			Integer b = pq.poll();
			Integer sum = a+b;
			answer += (sum);
			pq.add(sum);
		}
		System.out.println(answer);
	}
}


