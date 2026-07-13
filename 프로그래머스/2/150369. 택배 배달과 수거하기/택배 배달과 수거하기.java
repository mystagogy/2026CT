class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long delivery = 0;
        long pickup = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];
            
            long dTrip = 0;
            long pTrip = 0;
            
            if(delivery > 0) dTrip = (delivery + cap - 1) / cap;
            
            if(pickup > 0) pTrip = (pickup + cap - 1) / cap;
            
            long trip = Math.max(dTrip, pTrip);
            
            if(trip > 0) {
                answer += (i+1) * 2 * trip;
                delivery -= trip * cap;
                pickup -= trip * cap;
            }
        }
        return answer;
    }
}