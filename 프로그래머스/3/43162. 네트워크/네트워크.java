class Solution {
    static boolean[] visited;
    static int size;

    public int solution(int n, int[][] computers) {
        size = n;
        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int idx, int[][] computers) {
        visited[idx] = true;

        for (int i = 0; i < size; i++) {
            if (computers[idx][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}