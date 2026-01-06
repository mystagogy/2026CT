import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M,V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        V = Integer.parseInt(str[2]);

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb.toString());

    }

    static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx).append(" ");
        for(int i = 1; i <= N; i++) {
            if(graph[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");
            for(int i = 1; i <= N; i++){
                if(graph[curr][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
