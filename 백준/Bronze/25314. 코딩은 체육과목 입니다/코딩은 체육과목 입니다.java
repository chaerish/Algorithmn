import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static String base = "long int";
    static String LONG = "long";
    static String INT = "int";
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if (N == 4) {
            System.out.println(base);
            return;
        } else {
            int num = N / 4;
            for (int i = 0; i < num; i++) {
                sb.append(LONG).append(" ");
            }
            sb.append(INT);
            System.out.println(sb);
        }
    }
}