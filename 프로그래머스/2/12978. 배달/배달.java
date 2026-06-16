import java.util.*;
class Solution {
    static class Node implements Comparable<Node> {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static List<Node>[] graph;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        
        graph = new List[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int cost = road[i][2];
            graph[x].add(new Node(y, cost));
            graph[y].add(new Node(x, cost));
        }
        
        dijkstra(1);
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) answer++;
        }
        
        return answer;
        
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int nCost = current.cost;
            
            if(distance[now] < nCost) continue;
            
            for(Node next : graph[now]){
                int nextNode = next.index;
                int nextCost = nCost + next.cost;
                
                if(nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}