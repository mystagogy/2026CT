
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int next, cost;

    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int V, E, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[V+1];

        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));

        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.next;
            int cost =current.cost;
            
            if(cost > dist[now]) continue;
            
            for(Node next : list[now]) {
                if(dist[next.next] > dist[now] + next.cost) {
                    dist[next.next] = dist[now] + next.cost;
                    pq.offer(new Node(next.next, dist[next.next]));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);

    }
}
