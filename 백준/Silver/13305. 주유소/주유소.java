import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int oil[];
    static int money[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        oil = new int[N - 1];
        money = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        answer += oil[0] * money[0]; //처음꺼는 더함
        for (int i = 1; i < N - 1; i++) {
            int a = oil[i] * money[i - 1];
            int b = oil[i] * money[i];
            if (a > b) {
                answer += b;
            } else {
                answer += a;
            }
        }
        System.out.println(answer);
    }
}