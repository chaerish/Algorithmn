import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K = 0;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int idx = (K - 1) % list.size();
        answer.add(list.remove(idx));
        while (list.size() >= 1) {
            idx = (idx + K - 1) % list.size();
            answer.add(list.remove(idx));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i != answer.size() - 1) {
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }
        System.out.println(sb);
    }
}
