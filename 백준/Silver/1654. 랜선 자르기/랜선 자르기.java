import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] arr = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]); // 가장 긴 랜선 길이 저장
        }

        long left = 1; // 랜선 길이의 최소값
        long right = max; // 랜선 길이의 최대값
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int length : arr) {
                count += length / mid; // mid 길이로 잘라서 만들 수 있는 랜선 개수 계산
            }

            if (count >= N) { // 원하는 랜선 개수 이상이면
                result = mid; // 길이를 기록
                left = mid + 1; // 더 긴 길이를 탐색
            } else { // 원하는 랜선 개수보다 부족하면
                right = mid - 1; // 더 짧은 길이를 탐색
            }
        }

        System.out.println(result);
    }
}
