import java.util.*;

class Solution {
    static class Room implements Comparable<Room> {
        
        int startTime;
        int endTime;
        
        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public int compareTo(Room o){
            if(this.startTime == o.startTime){
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        
        for(String[] time : book_time) {
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            rooms.offer(new Room(startTime, endTime));
        }
        
        PriorityQueue<Integer> info = new PriorityQueue<>();
        while(!rooms.isEmpty()) {
            Room now = rooms.poll();
            
            if(!info.isEmpty() && info.peek() <= now.startTime) info.poll();
            
            info.offer(now.endTime);
        }
        
        return info.size();
    }
}