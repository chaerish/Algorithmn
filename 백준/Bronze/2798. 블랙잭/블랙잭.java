import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    슬라이딩 윈도우 문제 ? ->X 그럼 연속한 숫자들로만 구해짐.
     */
    static int N, M = 0;
    static int MAX = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        backtrack(0, 0, 0);
        System.out.println(MAX);
    }

    static private void backtrack(int depth, int idx, int sum) {
        if (depth == 3 && sum <= M) {
            MAX = Math.max(MAX, sum);
            return;
        }
        if (sum > M) {
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(depth + 1, idx + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}