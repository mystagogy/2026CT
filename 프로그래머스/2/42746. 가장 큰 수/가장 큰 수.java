import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        int i = 0;
        for(int num : numbers){
            str[i] = String.valueOf(num);
            i++;
        }
        
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb =new StringBuilder();
        for(String num : str) {
            sb.append(num);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}