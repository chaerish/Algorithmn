import java.util.*;

class Solution {
    static int n;
    static int[][] board;
    static boolean[][][][] visited;

    static class Robot {
        int r1, c1, r2, c2, time;

        Robot(int r1, int c1, int r2, int c2, int time) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.time = time;
        }
    }

    public int solution(int[][] inputBoard) {
        board = inputBoard;
        n = board.length;
        visited = new boolean[n][n][n][n];

        Queue<Robot> q = new LinkedList<>();

        q.offer(new Robot(0, 0, 0, 1, 0));
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;

        while (!q.isEmpty()) {
            Robot cur = q.poll();

            if ((cur.r1 == n - 1 && cur.c1 == n - 1) ||
                (cur.r2 == n - 1 && cur.c2 == n - 1)) {
                return cur.time;
            }

            for (Robot next : getNextPositions(cur)) {
                if (!visited[next.r1][next.c1][next.r2][next.c2]) {
                    visited[next.r1][next.c1][next.r2][next.c2] = true;
                    visited[next.r2][next.c2][next.r1][next.c1] = true;
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    private List<Robot> getNextPositions(Robot cur) {
        List<Robot> list = new ArrayList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 1. 상하좌우 이동
        for (int i = 0; i < 4; i++) {
            int nr1 = cur.r1 + dr[i];
            int nc1 = cur.c1 + dc[i];
            int nr2 = cur.r2 + dr[i];
            int nc2 = cur.c2 + dc[i];

            if (isEmpty(nr1, nc1) && isEmpty(nr2, nc2)) {
                list.add(new Robot(nr1, nc1, nr2, nc2, cur.time + 1));
            }
        }

        // 2. 회전
        if (cur.r1 == cur.r2) {
            // 가로 상태
            for (int d : new int[]{-1, 1}) {
                int nr1 = cur.r1 + d;
                int nr2 = cur.r2 + d;

                if (isEmpty(nr1, cur.c1) && isEmpty(nr2, cur.c2)) {
                    // 왼쪽 칸을 축으로 회전
                    list.add(new Robot(cur.r1, cur.c1, nr1, cur.c1, cur.time + 1));

                    // 오른쪽 칸을 축으로 회전
                    list.add(new Robot(cur.r2, cur.c2, nr2, cur.c2, cur.time + 1));
                }
            }
        } else {
            // 세로 상태
            for (int d : new int[]{-1, 1}) {
                int nc1 = cur.c1 + d;
                int nc2 = cur.c2 + d;

                if (isEmpty(cur.r1, nc1) && isEmpty(cur.r2, nc2)) {
                    // 위쪽 칸을 축으로 회전
                    list.add(new Robot(cur.r1, cur.c1, cur.r1, nc1, cur.time + 1));

                    // 아래쪽 칸을 축으로 회전
                    list.add(new Robot(cur.r2, cur.c2, cur.r2, nc2, cur.time + 1));
                }
            }
        }

        return list;
    }

    private boolean isEmpty(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && board[r][c] == 0;
    }
}