import java.util.*;

class Solution {
    static class Enemy implements Comparable<Enemy> {
        int index;
        int power;
        
        public Enemy(int index, int power) {
            this.index = index;
            this.power = power;
        }
        
        public int compareTo (Enemy o) {
            if(this.power == o.power){
                return this.index - o.index;
            }
            return o.power - this.power;
        }
    }
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Enemy> pq = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++){
            pq.offer(new Enemy(i, enemy[i]));
            
            n -= enemy[i];
            
            if(n < 0){
                if(k == 0) return i;
                Enemy strong = pq.poll();
            
                n += strong.power;
                k--;
            }
            
        }
        
        return enemy.length;
        
        
    }
}