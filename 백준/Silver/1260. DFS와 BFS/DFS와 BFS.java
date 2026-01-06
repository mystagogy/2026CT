import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,start;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i =1; i<N+1; i++){
            if(graph[start][i] == 1 && visited[i]==false){
                dfs(i);
            }
        }
    }

    public static void bfs( int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        visited[start] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");
            for(int i = 1; i <= N; i++){
                if(graph[temp][i]==1 && visited[i]==false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, Boolean.FALSE);
        bfs(start);

        System.out.println(sb.toString());
    }
}