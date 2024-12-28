import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스도쿠 보드 입력 받기
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 스도쿠 풀이
        solve(0, 0);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 백트래킹을 이용한 스도쿠 풀이 함수
    static boolean solve(int row, int col) {
        if (row == 9) {
            return true; // 모든 행을 처리 완료
        }

        // 다음 칸으로 이동
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        // 이미 채워진 칸인 경우
        if (board[row][col] != 0) {
            return solve(nextRow, nextCol);
        }

        // 빈 칸에 1부터 9까지 시도
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num; // 숫자 채우기
                if (solve(nextRow, nextCol)) {
                    return true; // 해결 완료
                }
                board[row][col] = 0; // 되돌리기
            }
        }

        return false; // 해결 불가능
    }

    // 숫자가 해당 칸에 유효한지 검사
    static boolean isValid(int row, int col, int num) {
        // 가로 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // 세로 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
