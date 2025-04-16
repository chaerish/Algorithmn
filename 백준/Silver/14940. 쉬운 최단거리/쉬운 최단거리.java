import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] road;
    static boolean[][] visited;
    static int N, M = 0;
    static int r, c = 0;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                String value = st.nextToken();
                if (value.equals("2")) {
                    r = i;
                    c = j;
                    continue;
                }
                road[i][j] = Integer.parseInt(value);
            }
        }
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && road[i][j] != 0) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(road[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r, c, 0});
        visited[r][c] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dis = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dx[i];
                int nc = cc + dy[i];
                if (isValid(nr, nc) && !visited[nr][nc] && road[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    dq.add(new int[]{nr, nc, dis + 1});
                    road[nr][nc] = dis + 1;
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return (r >= 0 && r < N) && (c >= 0 && c < M);
    }
}
