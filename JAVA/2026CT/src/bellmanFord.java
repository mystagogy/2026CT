import java.io.*;
import java.util.*;

public class bellmanFord {

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m, start;
    static List<Edge> edges = new ArrayList<>();
    static long[] distance;

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        boolean hasNegativeCycle = bellmanFord(start);

        if (hasNegativeCycle) {
            System.out.println("음수 사이클이 존재합니다.");
        } else {
            for (int i = 1; i <= n; i++) {
                if (distance[i] == INF) {
                    System.out.println(i + "번 정점까지 최단 거리: INF");
                } else {
                    System.out.println(i + "번 정점까지 최단 거리: " + distance[i]);
                }
            }
        }
    }

    static boolean bellmanFord(int start) {
        distance[start] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.from] == INF) {
                    continue;
                }

                if (distance[edge.to] > distance[edge.from] + edge.cost) {
                    distance[edge.to] = distance[edge.from] + edge.cost;
                }
            }
        }

        for (Edge edge : edges) {
            if (distance[edge.from] == INF) {
                continue;
            }

            if (distance[edge.to] > distance[edge.from] + edge.cost) {
                return true;
            }
        }

        return false;
    }
}