import java.util.*;

class Solution {
    static int answer = 100;
    static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        
        graph = new List[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i]  = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for(int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            int cnt = bfs(x, y, graph);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    static int bfs(int x, int y, List<Integer>[] graph) {
        int cnt = 1;
        boolean[] visited = new boolean[graph.length];
        visited[x] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph[current]) {
                if((current == x && next == y) || (current == y && next == x)) continue;
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}