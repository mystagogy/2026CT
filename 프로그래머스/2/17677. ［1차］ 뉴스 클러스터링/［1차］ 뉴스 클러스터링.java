import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i+2);
            if(str.matches("[A-Z]{2}")) map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i+2);
            if(str.matches("[A-Z]{2}")) map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        
        Set<String> words = new HashSet<>();
        
        words.addAll(map1.keySet());
        words.addAll(map2.keySet());
        
        int intersection = 0;
        int union = 0;
        for(String word : words) {
            int s1 = map1.getOrDefault(word, 0);
            int s2 = map2.getOrDefault(word, 0);
            
            intersection += Math.min(s1, s2);
            union += Math.max(s1, s2);
        }
        
        if(union == 0) return 65536;
        
        return (int) ((double) intersection / union * 65536);
    }
}