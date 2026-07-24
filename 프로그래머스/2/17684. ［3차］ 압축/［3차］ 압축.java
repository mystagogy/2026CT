import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(char ch = 'A'; ch <= 'Z'; ch++){
            map.put(String.valueOf(ch), ch - 'A' + 1);
        }
        
        int nextIdx = 27;
        int i = 0;
        while(i < msg.length()) {
            int end = i + 1;
            
            while(end <= msg.length() && map.containsKey(msg.substring(i, end))){
                end++;
            }
            
            String current = msg.substring(i, end-1);
            answer.add(map.get(current));
            
            if(end <= msg.length()){
                String newWord= msg.substring(i, end);
                map.put(newWord, nextIdx++);
            }
            
            i = end - 1;
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}