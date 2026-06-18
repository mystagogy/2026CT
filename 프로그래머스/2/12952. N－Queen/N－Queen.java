class Solution {
    static int answer;
    static int[] queen; 

    public int solution(int n) {
        answer = 0;
        queen = new int[n];

        dfs(0, n);

        return answer;
    }

    static void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isPossible(row, col)) {
                queen[row] = col;   
                dfs(row + 1, n);       
            }
        }
    }

    static boolean isPossible(int row, int col) {

        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queen[prevRow];

            if (prevCol == col) {
                return false;
            }
            
            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }

        return true;
    }
}