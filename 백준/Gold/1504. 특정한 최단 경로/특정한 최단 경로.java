import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, E, V1, V2;
    static int[] dist1, distV1, distV2;
    static List<Node>[] list;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        dist1 = new int[N+1];
        distV1 = new int[N+1];
        distV2 = new int[N+1];

        Arrays.fill(dist1, INF);
        Arrays.fill(distV1, INF);
        Arrays.fill(distV2, INF);

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, w));
            list[y].add(new Node(x, w));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        dijkstra(1, dist1);
        dijkstra(V1, distV1);
        dijkstra(V2, distV2);

        int d1 = INF;
        int d2 = INF;
        if(dist1[V1] != INF && distV1[V2] != INF && distV2[N] != INF) {
            d1 = dist1[V1] + distV1[V2] + distV2[N];
        } else {
            System.out.print(-1);
            return;
        }
        if(dist1[V2] != INF && distV2[V1] != INF && distV1[N] != INF) {
            d2 = dist1[V2] + distV2[V1] + distV1[N];
        } else {
            System.out.print(-1);
            return;
        }

        System.out.print(Math.min(d1, d2));

    }

    static void dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curr = current.dest;
            int weight = current.weight;

            if(dist[curr] < weight) continue;

            for(Node next : list[curr]) {
                int newDist = dist[curr] + next.weight;
                if(newDist < dist[next.dest]) {
                    dist[next.dest] = newDist;
                    pq.offer(new Node(next.dest, newDist));
                }
            }
        }
    }
}