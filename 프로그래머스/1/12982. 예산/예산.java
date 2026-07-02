import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int cnt = 0;
        for(int x : d) {
            if(x <= budget) {
                budget -= x;
                cnt++;
            } else break;
        }
        return cnt;
    }
}