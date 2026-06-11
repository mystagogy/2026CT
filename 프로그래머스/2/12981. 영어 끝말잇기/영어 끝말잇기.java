import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        int cnt = 0;
        set.add(words[0]);
        char c = words[0].charAt(words[0].length() - 1);
        for(int i =1 ; i < words.length; i++) {
            
            cnt++;
            
            String word = words[i];
            
            if(c != word.charAt(0))  break;

            c = word.charAt(word.length()-1);
            
            if(set.contains(word)) break;
            else set.add(word);
        
        }
        
        int[] answer = new int[2];
    
        
        if(words.length == set.size()) {
            answer = new int[]{0,0};
        } else {
            answer[0] = (cnt % n) + 1;
            answer[1] = (cnt / n) + 1;
        }
        return answer;
        
        
    }
}