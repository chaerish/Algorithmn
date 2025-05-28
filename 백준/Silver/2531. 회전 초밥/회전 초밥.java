import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
    static int N, d, k, c, max, eat = 0;
    static int[] sushi;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥가짓수
        k = Integer.parseInt(st.nextToken()); //연속해서 먹을 수 있는
        c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        arr = new int[N + k];
        sushi = new int[d + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            arr[i + N] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            if (++sushi[arr[i]] == 1) {
                eat++;
            }
        }
        max = eat + (sushi[c] == 0 ? 1 : 0);
        for (int i = k; i < N + k - 1; i++) {
            if (--sushi[arr[i - k]] == 0) {
                eat--;
            }
            if (++sushi[arr[i]] == 1) {
                eat++;
            }

            max = Math.max(max, eat + (sushi[c] == 0 ? 1 : 0));
        }
        System.out.println(max);
    }
}
