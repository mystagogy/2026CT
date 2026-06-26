import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int x : topping) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < topping.length; i++) {
            int now = topping[i];
            
            left.add(now);
            right.put(now, right.get(now) - 1);
            
            if(right.get(now) == 0) right.remove(now);
            
            if(left.size() == right.size()) answer++;
            
        }
        
        return answer;
        
    }
}