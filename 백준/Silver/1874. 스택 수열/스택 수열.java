import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> stack = new ArrayDeque<>();
    static int[] target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = (Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        int current = 1; //1부터 시작해서 N까지 푸쉬할 숫자
        int idx = 0;
        while (current <= N || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peekFirst() == target[idx]) {
                stack.pollFirst();
                sb.append("-").append("\n");
                idx++;
            } else if (current <= N) {
                stack.offerFirst(current++);
                sb.append("+").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}

