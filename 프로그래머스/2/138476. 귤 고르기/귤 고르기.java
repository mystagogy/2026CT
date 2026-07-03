import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        
        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int cnt = 0;
        for(int key: keyList) {
            k -= map.get(key);
            cnt++;
            if(k <= 0) break;
        }
        
        return cnt;
    }
}