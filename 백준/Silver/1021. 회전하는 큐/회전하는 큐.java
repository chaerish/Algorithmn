import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total = 0;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            int count = 0;
            while (dq.peekFirst() != (number)) {
                dq.offerLast(dq.pollFirst());
                count++;
            }
            count = Math.min(dq.size() - count, count);
            total += count;
            dq.pollFirst();
        }
        System.out.println(total);
    }
}