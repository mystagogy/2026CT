import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length() - 2);
        
        String[] sets = s.split("\\},\\{");
        
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        
        List<Integer> answerList = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        
        for (String set : sets) {
            String[] nums = set.split(",");
            
            for (String numStr : nums) {
                int num = Integer.parseInt(numStr);
                
                if (!used.contains(num)) {
                    used.add(num);
                    answerList.add(num);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}