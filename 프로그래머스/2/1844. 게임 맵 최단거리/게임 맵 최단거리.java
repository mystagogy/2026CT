import java.util.*;
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        bfs(0, 0, maps);
        
        int answer = maps[n-1][m-1];
        
        if(answer == 1) return -1;
        else return answer;
        
    }
    
    static void bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return;
    }
}