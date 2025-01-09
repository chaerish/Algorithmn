import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p = new int[n];  // 인력거의 위치
        int[] x = new int[n];  // 인력거가 갈 수 있는 거리

        // 인력거의 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        // 인력거가 갈 수 있는 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int cur = p[0] + x[0];  // 첫 번째 인력거로 이동할 수 있는 최대 거리
        int cnt = 0;  // 이동 횟수
        int idx = 1;  // 두 번째 인력거부터 시작

        while (cur < m) {  // 목표 지점에 도달할 때까지 반복
            int next = cur;  // 현재까지 도달할 수 있는 최대 거리
            while (idx < n && p[idx] <= cur) {  // 현재 위치에서 갈 수 있는 인력거 찾기
                next = Math.max(next, p[idx] + x[idx]);  // 가장 멀리 갈 수 있는 인력거를 선택
                idx++;
            }
            if (next == cur) {  // 이동할 수 있는 인력거가 없으면
                System.out.println(-1);
                return;
            }
            cur = next;  // 이동 후 현재 위치 갱신
            cnt++;  // 이동 횟수 증가
        }

        System.out.println(cnt);  // 결과 출력
    }
}
