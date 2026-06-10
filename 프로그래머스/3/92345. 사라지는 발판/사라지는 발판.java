class Solution {

    int n, m;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    class Result {
        boolean win;
        int cnt;

        Result(boolean win, int cnt) {
            this.win = win;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {

        n = board.length;
        m = board[0].length;

        return dfs(
                board,
                aloc[0], aloc[1],
                bloc[0], bloc[1]
        ).cnt;
    }

    private Result dfs(
            int[][] board,
            int ar, int ac,
            int br, int bc
    ) {

        if (board[ar][ac] == 0) {
            return new Result(false, 0);
        }

        boolean canMove = false;

        int winCnt = Integer.MAX_VALUE;
        int loseCnt = 0;

        for (int d = 0; d < 4; d++) {

            int nr = ar + dr[d];
            int nc = ac + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }

            if (board[nr][nc] == 0) {
                continue;
            }

            canMove = true;

            board[ar][ac] = 0;

            Result next =
                    dfs(
                            board,
                            br, bc,
                            nr, nc
                    );

            board[ar][ac] = 1;

            if (!next.win) {
                winCnt = Math.min(
                        winCnt,
                        next.cnt + 1
                );
            } else {
                loseCnt = Math.max(
                        loseCnt,
                        next.cnt + 1
                );
            }
        }

        if (!canMove) {
            return new Result(false, 0);
        }

        if (winCnt != Integer.MAX_VALUE) {
            return new Result(true, winCnt);
        }

        return new Result(false, loseCnt);
    }
}