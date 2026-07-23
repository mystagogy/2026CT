import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        dfs("");
        return dictionary.indexOf(word)+1;
    }
    
    void dfs(String word) {
        if(word.length() == 5) return;
        for(char vowel : vowels) {
            String next = word + vowel;
            
            dictionary.add(next);
            dfs(next);
        }
    }
}