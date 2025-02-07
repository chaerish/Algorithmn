import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static double answer = 0;
    static int N = 0;
    static double[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);
        int count = (int) Math.round(N * 0.15);
        for (int i = count; i < N - count; i++) {
            answer += arr[i];
        }
        System.out.println(Math.round(answer / (N - count * 2)));
    }
}
