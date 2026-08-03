import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        int answer = 0;
        for(int i = 0; i < len; i++) {
            int a = A[i];
            int b = B[len - i - 1];
            
            answer += a*b;
            
        }
        
        return answer;
    }
}