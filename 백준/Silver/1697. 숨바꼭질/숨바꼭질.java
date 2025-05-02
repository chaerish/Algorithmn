import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /**
     * 시간복잡도: 10^5 10^5 -> O(NlogN) 걷기: 수빈이 위치가 X일 때 걸으면? 1초 뒤에 X-1 or X+1로 이동하게 됨. 순간이동: 1초 뒤에 2*X로 이동 예제: 5 17 5 -> 10
     * -> 9 -> 18 -> 17 walk = {-1, 1} move = 2 int time = 0; while(true):
     */
    static int N, K, next = 0;
    static int[] move = {-1, 1, 2};
    static boolean[] visitied = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int MIN = Integer.MAX_VALUE;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{N, 0});
        bfs:
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == K) {
                MIN = Math.min(MIN, curr[1]);
                continue bfs;
            }
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    next = curr[0] * move[i];
                } else {
                    next = curr[0] + move[i];
                }
                if ((next >= 0 && next < visitied.length) && !visitied[next]) {
                    visitied[next] = true;
                    dq.add(new int[]{next, curr[1] + 1});
                }
            }
        }
        System.out.println(MIN);
    }
}
