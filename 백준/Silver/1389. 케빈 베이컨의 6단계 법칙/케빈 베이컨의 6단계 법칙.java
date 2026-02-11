import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int answer = 0;
    static List<Integer>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);

        }

        for(int i = 1; i <= N; i++){
            if(min > bfs(i)){
                min = bfs(i);
                answer = i;
            }
        }

        System.out.print(answer);

    }

    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            for(int next : graph[curr]) {
                if(dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++ ){
            sum += dist[i];
        }

        return sum;
    }



}
