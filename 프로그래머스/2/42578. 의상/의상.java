import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String item = cloth[0];
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        for(String key: map.keySet()) {
            int cnt = map.get(key);
            answer *= (cnt + 1);
        }
        
        return answer - 1;
    }
}