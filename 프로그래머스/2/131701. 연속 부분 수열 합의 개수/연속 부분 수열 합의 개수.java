import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int n = elements.length;
       
        for(int start = 0; start < n; start++) {
            int sum = 0;
            
            for(int len = 0; len < n; len++) {
                int idx = (start + len) % n;
                sum += elements[idx];
                set.add(sum);
            }
        }
        
        return set.size();
        
        
        
    }
}