class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Result {
        boolean win;
        int count;

        Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result result = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);
        return result.count;
    }

    static Result dfs(int[][] board, int cx, int cy, int ox, int oy) {

        if (board[cx][cy] == 0) {
            return new Result(false, 0);
        }

        boolean canWin = false;

        int minTurn = Integer.MAX_VALUE;

        int maxTurn = 0;

        int n = board.length;
        int m = board[0].length;

        for (int dir = 0; dir < 4; dir++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (board[nx][ny] == 0) {
                continue;
            }

            board[cx][cy] = 0;

            Result next = dfs(board, ox, oy, nx, ny);

            // 원상복구
            board[cx][cy] = 1;

            int turn = next.count + 1;

            if (!next.win) {
                canWin = true;
                minTurn = Math.min(minTurn, turn);
            } else {
                maxTurn = Math.max(maxTurn, turn);
            }
        }

        if (canWin) {
            return new Result(true, minTurn);
        }

        return new Result(false, maxTurn);
    }
}