import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 높이 이동 (위, 아래)
    static int[] dx = {1, -1, 0, 0, 0, 0}; // 가로 이동 (좌, 우)
    static int[] dy = {0, 0, -1, 1, 0, 0}; // 세로 이동 (위, 아래)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로(열)
        N = Integer.parseInt(st.nextToken()); // 세로(행)
        H = Integer.parseInt(st.nextToken()); // 높이(층)

        box = new int[H][N][M]; // 3차원 배열 선언
        Queue<int[]> queue = new LinkedList<>();
        int totalTomatoes = 0, ripeTomatoes = 0;

        // 입력 처리
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());

                    if (box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                        ripeTomatoes++;
                    }
                    if (box[h][n][m] != -1) {
                        totalTomatoes++;
                    }
                }
            }
        }

        if (ripeTomatoes == totalTomatoes) {
            System.out.println(0);
            return;
        }

        // BFS 탐색
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int z = cur[0], x = cur[1], y = cur[2];

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isValid(nz, nx, ny) && box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1; // 익음
                        queue.offer(new int[]{nz, nx, ny});
                        ripeTomatoes++;
                    }
                }
            }
            days++;
        }

        // 결과 출력
        System.out.println(ripeTomatoes == totalTomatoes ? days : -1);
    }

    private static boolean isValid(int z, int x, int y) {
        return z >= 0 && z < H && x >= 0 && x < N && y >= 0 && y < M;
    }
}
