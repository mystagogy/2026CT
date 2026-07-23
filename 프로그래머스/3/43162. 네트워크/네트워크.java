class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n]; //방문 확인 배열
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
        
    }
    static void dfs(int idx, int n, int[][] computers){
        visited[idx] = true; //방문 완료
        for(int i = 0; i < n; i++) {
            if(computers[idx][i] == 1 && !visited[i]){
                dfs(i, n, computers);
            }
        }
    }
}