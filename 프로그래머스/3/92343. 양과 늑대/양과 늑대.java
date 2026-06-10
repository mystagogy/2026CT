import java.util.*;
class Solution {
    int answer = 0;
    int[] info;
    List<Integer>[] children;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        int n = info.length;
        children = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            children[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            children[parent].add(child);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.addAll(children[0]);
        
        dfs(1, 0, candidates);
        
        return answer;
    }
    
    void dfs(int sheep, int wolf, List<Integer> candidates) {
        answer = Math.max(sheep, answer);
        
        for(int i = 0; i < candidates.size(); i++) {
            int node = candidates.get(i);
            
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(info[node] == 0) nextSheep++;
            else nextWolf++;
            
            if(nextWolf >= nextSheep) continue;
            
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            
            nextCandidates.remove(Integer.valueOf(node));
            
            nextCandidates.addAll(children[node]);
            
            dfs(nextSheep, nextWolf, nextCandidates);
        }
    }
}