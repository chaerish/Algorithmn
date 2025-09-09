import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     자신의 길이보다 작거나 같은 높이의 과일
     N = 10^3, L = 10^4
     O(NL)로 끝내야함.
     처음 길이는 10
     10+1+1
     받고 정렬해서, 작거나 같은 원소들만 count
     */
    static int N, L, count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);
        for (int num : arr) {
            if (num <= L) {
                L++;
            }
        }
        System.out.println(L);

    }
}
