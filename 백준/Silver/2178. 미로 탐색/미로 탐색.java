import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0;
    static boolean[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {-0, 0, -1, 1};
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                boolean value = split[j].equals("1");
                map[i][j] = value;
            }
        }
        dq.add(new int[]{0, 0, 1});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cdis = cur[2];
            if(cr == N-1 && cc == M-1){
                cnt = cdis;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int r = cr + dr[i];
                int c = cc + dc[i];
                if (isValid(r, c) && map[r][c]) {
                    map[r][c] = false;
                    cnt = cdis + 1;
                    dq.offer(new int[]{r, c, cnt});
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
