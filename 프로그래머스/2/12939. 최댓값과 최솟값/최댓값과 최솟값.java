import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        
        int i = 0;
        for(String num : str){
            arr[i] = Integer.parseInt(num);
            i++;
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]).append(" ").append(arr[str.length - 1]);
        
        return sb.toString();
        
    }
}