import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	static int T = 10;
	static boolean [][] visited;
	static Deque<int[]> dq;
	static boolean [][] miro;
	static int [] dr = {-1,1,0,0}; //상하좌우 움직이는 방향성 ? 
	static int [] dc = {0,0,-1,1};
	public static void main(String [] args) throws NumberFormatException, IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test = 1; test<=T; test++) {
			br.readLine();
			miro = new boolean[16][16];
			int sr=0,sc=0,er=0,ec=0;
			for(int i = 0; i<16; i++) {
				String arr = br.readLine();
				for(int j=0; j<16; j++) {
					miro[i][j] = arr.charAt(j) == '1';
					if(arr.charAt(j)=='2') {
						sr = i;
						sc = j;
					}
					if(arr.charAt(j)=='3') {
						er = i;
					    ec = j;
					}
				}
			}
			dq = new ArrayDeque<>();
			visited = new boolean[16][16];
			//방문 시작.....
			dq.offer(new int[] {sr,sc});
			visited[sr][sc] = true; //방문 처리
			int result = 0;
			while(!dq.isEmpty()) {//큐가 비지 않을 때까지 
				int [] cur = dq.poll();
				if(cur[0] == er && cur[1] == ec) {
					result = 1;
					break;
				}
				for(int i = 0; i<4; i++) {
					int nr = cur[0]+ dr[i];
					int nc = cur[1]+ dc[i]; //방향값 
					if(isValid(nr,nc)){
						if(!visited[nr][nc] && !miro[nr][nc]) {
							dq.offer(new int[] {nr,nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static boolean isValid(int r, int c) {
		return 0 <= r && r < 16 && 0 <= c && c < 16;
	}
}