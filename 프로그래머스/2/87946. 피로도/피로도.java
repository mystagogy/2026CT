class Solution {
    static int answer = 0;
    static int n;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int cnt = 0;
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k, 0, dungeons);
        return answer;
    }
    
    static void dfs(int k, int cnt, int[][] dungeons){
        
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < n; i++) {
            
            if(!visited[i]) {
                int[] point = dungeons[i];
                int need = point[0];
                int consume = point[1];
                
                if(k >= need) {
                    visited[i] = true;
                    dfs(k - consume, cnt+1, dungeons);
                    visited[i] = false;
                }
            }   
        }
    }
}