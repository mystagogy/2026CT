import java.util.*;
class Solution {
    
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] command = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int min = Math.abs(x-r) + Math.abs(y-c);
        if(min > k || (k - min) % 2 != 0) return "impossible";
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < k; i++) {
            int rest = k - i - 1;
            
            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                
                int distance = Math.abs(nx - r) + Math.abs(ny - c);
                if(distance <= rest && (rest - distance) % 2 == 0) {
                    answer.append(command[j]);
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}