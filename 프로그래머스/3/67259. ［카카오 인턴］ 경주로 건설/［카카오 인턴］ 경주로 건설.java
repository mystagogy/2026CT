import java.util.*;
class Solution {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] cost;
    public int solution(int[][] board) {
        
        n = board.length;
        cost = new int[n][n][4];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        return bfs(0, 0, board);
        
    }
    
    static int bfs(int a, int b, int[][] board) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b, 0, -1});
        int answer = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentCost = current[2];
            int dir = current[3];
            
            if(x == n -1 && y == n -1) {
                answer = Math.min(answer, currentCost);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int ndir = i;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[nx][ny] == 1) continue;
                
                int nCost = 0;
                if(dir == -1) {
                    nCost = currentCost + 100; 
                } else {
                    if(dir == ndir) {
                        nCost = currentCost + 100;
                    } else {
                        nCost = currentCost + 600;   
                    }
                }
                
                if(nCost < cost[nx][ny][ndir]) {
                    cost[nx][ny][ndir] = nCost;
                    queue.offer(new int[]{nx, ny, nCost, ndir});
                }
            }
        }
        return answer;
    }
}