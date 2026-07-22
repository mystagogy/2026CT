import java.util.*;

class Solution {
    static class Process {
        int index;
        int priority;
        
        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        
        Queue<Process> queue = new ArrayDeque();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        int order = 0;
        
        while(!queue.isEmpty()) {
            Process current = queue.poll();
            
            if(current.priority == pq.peek()) {
                pq.poll();
                order++;
                
                if(current.index == location) return order;
                
            } else queue.offer(current);
        }
        
        return -1;
    }
}