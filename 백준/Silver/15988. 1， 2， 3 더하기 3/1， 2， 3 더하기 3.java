import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        num = new int[T];
        for(int i = 0; i < T; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(num[i], max);
        }

        StringBuilder sb = new StringBuilder();

        long[] dp = new long[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= max; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }

        for(int i = 0; i < T; i++){
            sb.append(dp[num[i]]).append("\n");
        }

        System.out.print(sb.toString());
    }

}
