import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x1, y1, x2, y2, r1, r2, T = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             x1 = Integer.parseInt(st.nextToken());
             y1 = Integer.parseInt(st.nextToken());
             r1 = Integer.parseInt(st.nextToken());

             x2 = Integer.parseInt(st.nextToken());
             y2 = Integer.parseInt(st.nextToken());
             r2 = Integer.parseInt(st.nextToken());
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
            double sub = Math.abs(r2 - r1);
            if (distance == 0 && r1 == r2) {//완전히 같을 경우
                sb.append(-1);
            } else if (distance < r1 + r2 && sub < distance) {
                sb.append(2);
            } else if (distance == r1 + r2 || sub == distance) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}