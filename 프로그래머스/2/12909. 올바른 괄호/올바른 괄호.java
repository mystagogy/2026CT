import java.util.*;

class Solution {
    boolean solution(String s) {
        int n = s.length();
        if(s.charAt(n-1) == '(') return false;
        
        char[] ch = s.toCharArray();
        int count = 0;
        for(char c : ch) {
            if(c == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        
        if(count == 0) return true;
        else return false;
        
        
        
    }
}