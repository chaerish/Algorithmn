import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /*상하좌우 큐에 계속 넣고 체크 만약 0이나오면 넣지않고 ->
    큐가 비게되면 배추가 잇는 다른 좌표를 넣음.
     필요한것: Deque, Boolean [][] 배열 -> true이면 배추가 있는거임
     그리고 count 증가
     */
    static int count;
    static boolean[][] arr;
    static int T, M, N, K, X, Y;
    static Deque<int[]> dq = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //위치의 갯수
            arr = new boolean[M][N];
            visited = new boolean[M][N];
            count = 0;
            dq = new ArrayDeque<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = true;
                dq.add(new int[]{X, Y});
            }
            Deque<int[]> near;
            while (!dq.isEmpty()) {
                int[] ar = dq.poll();
                int x = ar[0];
                int y = ar[1];
                if (visited[x][y]) {
                    continue;
                }
                count++;
                near = new ArrayDeque<>();
                near.add(new int[]{x, y});
                while (!near.isEmpty()) {
                    int[] nn = near.poll();
                    int nnx = nn[0];
                    int nny = nn[1];
                    for (int i = 0; i < 4; i++) {
                        int nx = nnx + dx[i];
                        int ny = nny + dy[i];
                        if (isValid(nx, ny) && !visited[nx][ny] && arr[nx][ny]) {
                            visited[nx][ny] = true;
                            near.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}