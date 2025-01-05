import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static long MAX, profit = 0;
    static long arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int test = 0; test < N; test++) {
            int size = Integer.parseInt(br.readLine());
            arr = new long[size];
            profit = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            MAX = Long.MIN_VALUE;
            for (int i = size - 1; i >= 0; i--) {
                if (arr[i] > MAX) {
                    MAX = arr[i];
                } else {
                    profit += MAX - arr[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}