import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
        }

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        bfs(X);

        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i = 0; i <= N; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
                check = true;
            }
        }
        if(!check) System.out.print(-1);
        else System.out.print(sb.toString());

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(int next : graph.get(curr)) {
                if(dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
    }

}
