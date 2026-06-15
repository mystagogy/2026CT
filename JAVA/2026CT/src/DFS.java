import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {
    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        V = Integer.parseInt(str[2]);

        graph = new List[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);

        sb.append("\n");

        Arrays.fill(visited, false);
        bfs(V);

        System.out.println(sb);


    }

    static void dfs(int idx){

        visited[idx] = true;
        sb.append(idx).append(" ");

        for(int x : graph[idx]) {
            if(!visited[x]) dfs(x);
        }

    }

    static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();

        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");

            for(int next : graph[x]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
