import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static int[][] map;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtrack(0, 0);
        System.out.println(MIN);
    }

    private static void backtrack(int start, int depth) {
        if (depth == N / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            //팀 간 능력치 차이 계산
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (k == j) {
                        continue;
                    } else if (visited[k] && visited[j]) {
                        startTeam += map[j][k];
                    } else if (!visited[k] && !visited[j]) {
                        linkTeam += map[j][k];
                    }
                }
            }
            int diff = Math.abs(startTeam - linkTeam);
            MIN = Math.min(diff, MIN);
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) { //방문하지 않았으면
                visited[i] = true; //방문처리하고,
                backtrack(i + 1, depth + 1); //나머지 팀원들을 찾는다.
                visited[i] = false; //백트래킹. 돌아오고 나서는 다시 탐색을 위해 되돌림.
            }
        }
    }
}