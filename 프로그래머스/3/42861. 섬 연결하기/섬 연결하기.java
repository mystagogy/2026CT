import java.util.*;
class Solution {
    static int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        for(int[] cost : costs) {
            int A = cost[0];
            int B = cost[1];
            int bCost = cost[2];
            
            if(find(A) != find(B)) {
                union(A, B);
                answer += bCost;
            }
            
        }
        
        return answer;
    }
    
    int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) parent[rootB] = rootA;
    }
}