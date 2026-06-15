import java.io.*;
import java.util.*;

public class dijkstra {

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    static int n, m, start;
    static List<Node>[] graph;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                System.out.println(i + "번 정점까지 최단 거리: INF");
            } else {
                System.out.println(i + "번 정점까지 최단 거리: " + distance[i]);
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int now = current.index;
            int nowCost = current.cost;

            if (distance[now] < nowCost) {
                continue;
            }

            for (Node next : graph[now]) {
                int nextNode = next.index;
                int nextCost = nowCost + next.cost;

                if (nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}