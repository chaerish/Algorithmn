import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    슬라이딩 윈도우 문제 ? ->X 그럼 연속한 숫자들로만 구해짐.
     */
    static int N, M = 0;
    static int MAX = Integer.MIN_VALUE;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = 0;
            sum += arr[i];
            for (int j = i + 1; j < N; j++) {
                sum += arr[j];
                for (int x = j + 1; x < N; x++) {
                    sum += arr[x];
                    if (sum <= M) {
                        MAX = Math.max(sum, MAX);
                    }
                    sum -= arr[x];
                }
                sum -= arr[j];
            }
            sum -= arr[i];
        }
        System.out.println(MAX);
    }
}