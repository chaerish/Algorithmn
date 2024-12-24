import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = ' ';
            }
        }

        drawStar(0, N - 1, N); // 시작 좌표와 삼각형 크기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void drawStar(int x, int y, int size) {
        if (size == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = '*';
            map[x + 2][y - 1] = '*';
            map[x + 2][y] = '*';
            map[x + 2][y + 1] = '*';
            map[x + 2][y + 2] = '*';
            return;
        }

        int newSize = size / 2;
        // 위쪽 삼각형
        drawStar(x, y, newSize);
        // 왼쪽 아래 삼각형
        drawStar(x + newSize, y - newSize, newSize);
        // 오른쪽 아래 삼각형
        drawStar(x + newSize, y + newSize, newSize);
    }
}