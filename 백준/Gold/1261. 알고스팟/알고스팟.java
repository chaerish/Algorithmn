import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 (열)
        N = Integer.parseInt(st.nextToken()); // 세로 (행)

        map = new boolean[N][M];
        dist = new int[N][M]; // 방문 거리 저장 배열
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE); // 최댓값으로 초기화
            for (int j = 0; j < M; j++) {
                map[i][j] = (line[j] == '1'); // 벽이면 true, 빈 방이면 false
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1];

            // 목표 지점에 도달하면 최소 벽 부수기 횟수 반환
            if (x == N - 1 && y == M - 1) {
                return dist[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
                    int newDist = dist[x][y] + (map[cx][cy] ? 1 : 0);

                    // 이미 더 좋은 경로로 방문했다면 패스
                    if (newDist < dist[cx][cy]) {
                        dist[cx][cy] = newDist; // 거리 갱신

                        if (map[cx][cy]) {
                            deque.addLast(new int[]{cx, cy}); // 벽이면 뒤에 추가 (후순위 탐색)
                        } else {
                            deque.addFirst(new int[]{cx, cy}); // 빈 방이면 앞에 추가 (우선 탐색)
                        }
                    }
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (문제 조건상 항상 도달 가능)
    }
}
