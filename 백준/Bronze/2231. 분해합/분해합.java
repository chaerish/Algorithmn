import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, num, sum;
    static String var = "";
    static int MIN = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var = br.readLine();
        N = Integer.parseInt(var);
        for (int x = 1; x < N; x++) {
            sum = x;
            num = x;
            while (num > 0) {
                sum += num % 10; // 각자리수 더하기
                num /= 10; //다음수만 남기기
            }
            if (sum == N) {
                System.out.println(x);
                return;
            }

        }
        System.out.println(0);
    }
}