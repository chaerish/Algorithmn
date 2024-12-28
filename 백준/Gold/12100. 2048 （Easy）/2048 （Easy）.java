import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(maxBlock);
    }

    // 깊이 우선 탐색
    static void dfs(int depth, int[][] currentBoard) {
        if (depth == 5) { // 최대 5번 이동
            findMaxBlock(currentBoard);
            return;
        }

        for (int i = 0; i < 4; i++) { // 네 방향 탐색
            int[][] nextBoard = move(i, currentBoard);
            dfs(depth + 1, nextBoard);
        }
    }

    // 현재 보드에서 가장 큰 블록 찾기
    static void findMaxBlock(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
    }

    // 블록 이동 처리
    static int[][] move(int direction, int[][] currentBoard) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(currentBoard[i], 0, newBoard[i], 0, N);
        }

        switch (direction) {
            case 0: // 위로 이동
                for (int col = 0; col < N; col++) {
                    slideAndMerge(newBoard, 0, 1, col, true);
                }
                break;
            case 1: // 아래로 이동
                for (int col = 0; col < N; col++) {
                    slideAndMerge(newBoard, N - 1, -1, col, true);
                }
                break;
            case 2: // 왼쪽으로 이동
                for (int row = 0; row < N; row++) {
                    slideAndMerge(newBoard, 0, 1, row, false);
                }
                break;
            case 3: // 오른쪽으로 이동
                for (int row = 0; row < N; row++) {
                    slideAndMerge(newBoard, N - 1, -1, row, false);
                }
                break;
        }
        return newBoard;
    }

    // 블록 슬라이드와 합치기 처리
    static void slideAndMerge(int[][] board, int start, int step, int fixed, boolean isColumn) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int value = isColumn ? board[start + step * i][fixed] : board[fixed][start + step * i];
            if (value != 0) {
                deque.add(value);
            }
        }

        List<Integer> merged = new ArrayList<>();
        while (!deque.isEmpty()) {
            int current = deque.poll();
            if (!deque.isEmpty() && current == deque.peek()) {
                merged.add(current * 2);
                deque.poll();
            } else {
                merged.add(current);
            }
        }

        while (merged.size() < N) {
            merged.add(0);
        }

        for (int i = 0; i < N; i++) {
            if (isColumn) {
                board[start + step * i][fixed] = merged.get(i);
            } else {
                board[fixed][start + step * i] = merged.get(i);
            }
        }
    }
}

