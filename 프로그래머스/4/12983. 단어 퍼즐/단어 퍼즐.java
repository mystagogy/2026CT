import java.util.*;
class Solution {
    static int INF = Integer.MAX_VALUE;
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length()+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i = 0; i <= t.length(); i++) {
            
            if(dp[i] == INF) continue;
            
            for(String word : strs) {
                
                int next = i + word.length();
                
                if(next <= t.length()) {
                    if(t.startsWith(word, i)) {
                        dp[next] = Math.min(dp[next], dp[i] + 1);
                    }
                }
            }
        }
        
        return dp[t.length()] == INF ? -1 : dp[t.length()];
    }
}