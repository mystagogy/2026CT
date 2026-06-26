class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zero = 0;
        
        while(!s.equals("1")) {
            
             StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '0') zero++;
                else sb.append(ch);
            }
            
            int len = sb.length();
            s = Integer.toBinaryString(len);
            cnt++;
            
        }
        return new int[]{cnt, zero};
    }
}