import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[]; //선택 저장할 배열
    static int N, M = 0;
    static boolean visit[]; //중복
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        arr = new int[M];
        recursive(0);
        System.out.println(sb);
    }

    private static void recursive(int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                if (depth == M - 1) {
                    visit[i] = true;
                }
                arr[depth] = i;
                recursive(depth + 1);
                visit[i] = false;
            }
        }
    }
}