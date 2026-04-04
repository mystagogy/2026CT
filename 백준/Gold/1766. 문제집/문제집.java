import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        int[] degree = new int[N+1];

        for(int i = 01; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            degree[b]++;

        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(degree[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int next : graph[current]) {
                degree[next]--;
                if(degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb);

    }

}