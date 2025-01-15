import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wages = new int[n + 1]; // 마지막에 0 추가
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            wages[i] = Integer.parseInt(st.nextToken());
        }
        wages[n] = 0; // 끝에 0을 추가해 모든 구간 계산 가능하도록 설정

        Deque<Integer> stack = new ArrayDeque<>();
        long maxProfit = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && wages[i] < wages[stack.peek()]) {
                int height = wages[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxProfit = Math.max(maxProfit, (long) height * width);
            }
            stack.push(i);
        }
        System.out.println(maxProfit);
    }
}
