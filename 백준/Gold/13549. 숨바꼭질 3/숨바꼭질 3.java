import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /**
     * 순간이동 할 경우에는 0초 후에 2*X의 위치로 이동하게 됨.
     */
    static int N, K, next, time = 0;
    static int[] move = {2, -1, 1};
    static boolean[] visitied = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int MIN = Integer.MAX_VALUE;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{N, 0});
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            if (curr[0] == K) {
                System.out.println(curr[1]);
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = curr[0] * move[i];
                } else {
                    next = curr[0] + move[i];
                }
                if ((next >= 0 && next < visitied.length) && !visitied[next]) {
                    visitied[next] = true;
                    if (i == 0) {
                        dq.addFirst(new int[]{next, curr[1]});
                    } else {
                        dq.addLast(new int[]{next, curr[1] + 1});
                    }
                }
            }
        }
    }
}
