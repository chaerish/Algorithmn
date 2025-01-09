import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N = 0;
    static long result = 0;
    static List<Integer> positive = new ArrayList<>();
    static List<Integer> negative = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num <= 0) {
                negative.add(Math.abs(num));
            } else if (num == 1) {
                result += 1;
            }

        }
        positive.sort(Collections.reverseOrder());
        negative.sort(Collections.reverseOrder());
        for (int i = 0; i < positive.size(); i += 2) {// 2,1
            if (i + 1 < positive.size()) {
                result += (long) positive.get(i) * positive.get(i + 1);
            } else {
                result += positive.get(i);
            }
        }
        for (int i = 0; i < negative.size(); i += 2) {// 2,1
            if (i + 1 < negative.size()) {
                result += (long) negative.get(i) * negative.get(i + 1);
            } else {
                result += (-negative.get(i));
            }
        }
        System.out.println(result);
    }
}