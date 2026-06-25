import java.util.*;

class Solution {
    static int n;
    static int[][] group;
    static boolean[][] visited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        n = land.length;
        group = new int[n][n];
        visited = new boolean[n][n];
        edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(group[i], -1);
        }
        
        int groupId = 0;
        
        // 1. height 이하로 이동 가능한 칸들을 같은 영역으로 묶기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, groupId, land, height);
                    groupId++;
                }
            }
        }
        
        // 2. 서로 다른 영역 사이의 간선 만들기
        makeEdges(land);
        
        // 3. Union-Find 초기화
        parent = new int[groupId];
        
        for (int i = 0; i < groupId; i++) {
            parent[i] = i;
        }
        
        // 4. 간선 비용 오름차순 정렬
        Collections.sort(edges);
        
        // 5. 크루스칼 알고리즘
        int answer = 0;
        
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                answer += edge.cost;
            }
        }
        
        return answer;
    }
    
    static void bfs(int startX, int startY, int groupId, int[][] land, int height) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        group[startX][startY] = groupId;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                int diff = Math.abs(land[x][y] - land[nx][ny]);
                
                if (diff <= height) {
                    visited[nx][ny] = true;
                    group[nx][ny] = groupId;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    static void makeEdges(int[][] land) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    
                    int from = group[x][y];
                    int to = group[nx][ny];
                    
                    if (from != to) {
                        int cost = Math.abs(land[x][y] - land[nx][ny]);
                        edges.add(new Edge(from, to, cost));
                    }
                }
            }
        }
    }
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if (pa == pb) {
            return false;
        }
        
        parent[pb] = pa;
        return true;
    }
}