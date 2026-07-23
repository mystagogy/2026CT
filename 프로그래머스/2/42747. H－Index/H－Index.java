import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            int cnt = citations.length - i;
            if (citations[i] >= cnt) {
                return cnt;
            }
        }
        return 0;
    }
}