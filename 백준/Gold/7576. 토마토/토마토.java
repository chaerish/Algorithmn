import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int M, N, total, riped = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 1) {
                    riped++;
                    dq.add(new int[]{i, j});
                }
                if (value != -1) {
                    total++;
                }
            }
        }
        // 모든 토마토가 이미 익어있다면 0 출력
        if (total == riped) {
            System.out.println(0);
            return;
        }

        int day = -1;
        while (!dq.isEmpty()) {
            // 큐에 있는 모든 토마토에 대해 인접한 곳을 처리
            int size = dq.size();
            for (int s = 0; s < size; s++) {
                int[] cur = dq.poll();
                for (int i = 0; i < 4; i++) {
                    int r = cur[0] + dr[i];
                    int c = cur[1] + dc[i];
                    if (isValid(r, c) && map[r][c] == 0) {
                        map[r][c] = 1;
                        riped++;
                        dq.add(new int[]{r, c});
                    }
                }
            }
            day++;
        }
        // 만약 모든 토마토가 익지 못했으면 -1 출력
        System.out.println(total != riped ? -1 : day);
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
