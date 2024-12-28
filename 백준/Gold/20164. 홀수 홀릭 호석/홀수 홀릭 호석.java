import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recursive(N, 0);
        System.out.println(min + " " + max);
    }

    private static void recursive(int value, int count) {
        count += count(value);
        if (value / 10 == 0) { //한자리 수일때
            min = Math.min(min, count);
            max = Math.max(max, count);
            return;
        }
        if (value / 100 == 0) {//두자리수일때
            int num = value / 10 + value % 10;
            recursive(num, count);
        } else { //세자리수이상일때
            String str = String.valueOf(value);
            for (int i = 0; i < str.length() - 2; i++) {
                for (int j = i + 1; j < str.length() - 1; j++) {
                    int num = Integer.parseInt(str.substring(0, i + 1));
                    num += Integer.parseInt(str.substring(i + 1, j + 1));
                    num += Integer.parseInt(str.substring(j + 1));
                    recursive(num, count);
                }
            }
        }
    }

    private static int count(int value) {
        int count = 0;
        while (value > 0) {
            if ((value % 10) % 2 == 1) {
                count++;
            }
            value /= 10;
        }
        return count;
    }
}