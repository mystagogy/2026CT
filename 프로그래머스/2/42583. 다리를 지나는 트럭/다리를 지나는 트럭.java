import java.util.*;

class Solution {
    static class Node{
        int truck;
        int entryTime;
        
        Node(int truck, int entryTime){
            this.truck = truck;
            this.entryTime = entryTime;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> trucks = new ArrayList<>();
        for(int truck : truck_weights){
            trucks.add(truck);
        }
        
        int time = 0;   //시간
        int weightSum = 0;     //다리 위 트럭 무게 합
        int index = 0;
        
        while(index < truck_weights.length || !queue.isEmpty()){
            time++;
            
            //1.다리를 모두 건넌 트럭 제거
            if(!queue.isEmpty()){
                Node first = queue.peek();
                if(time - first.entryTime == bridge_length){
                    queue.poll();
                    weightSum -= first.truck;
                }
            }
            
            //2. 다음 트럭이 다리에 올라갈 수 있는지
            if(index < truck_weights.length && weightSum + truck_weights[index] <= weight){
                int newTruck = truck_weights[index];
                queue.offer(new Node(newTruck, time));
                weightSum += newTruck;
                index++;
            }
        }
 
         return time;
    }
}