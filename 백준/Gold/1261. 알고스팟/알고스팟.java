import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M = 0;
    static boolean[][] visited;
    static int[][] wallArr;
    static int[][] broken;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M + 1][N + 1];
        wallArr = new int[M + 1][N + 1];
        broken = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            char[] carr = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                wallArr[i][j] = carr[j - 1] - '0';
                broken[i][j] = (int) 1e9;
            }
        }
        broken[1][1] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{1, 1});
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            visited[x][y] = true;

            if (x == M && y == N) {
                System.out.println(broken[x][y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    int newWall = wallArr[x][y] + broken[x][y];
                    if (newWall < broken[nx][ny]) {
                        broken[nx][ny] = newWall;
                        if (wallArr[nx][ny] == 1) {
                            dq.addLast(new int[]{nx, ny});
                        } else if (wallArr[nx][ny] == 0) {
                            dq.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return y >= 1 && y <= N && x >= 1 && x <= M;
    }
}
