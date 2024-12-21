
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    private static void hanoi(int N, int start, int mid, int to) {
        if (N == 1) { //이동해야할 원반의 수가 1개일때
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        // A -> B 로 옮길 때. N-1개를 A에서 B로 이동
        hanoi(N - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        // B-> C
        hanoi(N - 1, mid, start, to);
    }
}