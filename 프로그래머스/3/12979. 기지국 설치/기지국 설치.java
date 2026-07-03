class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int len = 2*w + 1;
        int start = 1;
        int answer = 0;
        
        for(int station: stations) {
            int left = station - w;
            int right = station + w;
            
            if(start < left) {
                int emptylen = left - start;
                answer += (emptylen + len - 1) / len; 
            }
            
            start = right + 1;
        }
        
        if(start <= n) {
            int emptylen = n - start + 1;
            answer += (emptylen + len - 1) / len;
        }
        
        return answer;
    }
}