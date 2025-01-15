import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> wait = new ArrayDeque<>();
    static Deque<Integer> bridge = new ArrayDeque<>();
    static int time, N, W, L = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wait.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }
        int weight = 0;
        while (!bridge.isEmpty()) {
            time++;
            weight -= bridge.poll();
            if (!wait.isEmpty()) {
                int truck = wait.peek();
                if (weight + truck <= L) { //대기중인 트럭이 올라갈 수 있는지 확인한다.
                    bridge.add(truck);
                    wait.poll();
                    weight += truck;
                } else {
                    bridge.add(0); //다리길이 유지
                }
            }
        }
        System.out.println(time);
    }
}