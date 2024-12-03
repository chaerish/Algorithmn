import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Integer> hpq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			hpq.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int maxBox = hpq.poll();
			int give = Integer.parseInt(st.nextToken());
			if(maxBox < give) {
				System.out.println(0);
				return;
			}
			if(maxBox>give) { //선물이 남았으면 
				hpq.add(maxBox - give);
			}
		}	
		System.out.println(1);
	}
}

