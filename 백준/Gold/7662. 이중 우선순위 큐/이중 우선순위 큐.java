import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int T;
	static int K;
	static TreeMap<Integer,Integer> map;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int test = 0; test< T ; test++) {
			K = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			for(int i = 0; i<K;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String m = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(m.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}else if(map.size() == 0){
					continue;
				}
				else if(m.equals("D") && num == -1){ //최솟값삭제
					remove(map.firstKey());
				}else if(m.equals("D") && num == 1) { // 최댓값삭제
					remove(map.lastKey());
				}
			}
			if(map.size()==0) {
				sb.append("EMPTY").append("\n");
			}else {
				int min = map.firstKey();
				int max = map.lastKey();
				sb.append(max).append(" ").append(min).append("\n");	
			}
		}
		System.out.println(sb);		
	}
	private static void remove(int index) {
		if(map.put(index, map.get(index)-1)==1) {
			map.remove(index);
		}
	}
}