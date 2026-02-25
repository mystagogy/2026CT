import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, newScore, P;
    static int[] scores;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        newScore = Integer.parseInt(str[1]);
        P = Integer.parseInt(str[2]);

        scores = new int[P];

        if(N != 0){
            str = br.readLine().split(" ");
            for(int i = 0; i < str.length; i++){
                scores[i] = Integer.parseInt(str[i]);
            }
        }

        if (N == P && N > 0 && scores[N-1] >= newScore) {
            System.out.println(-1);
            return;
        }
        
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scores[i] > newScore) rank++;
            else break; 
        }
        System.out.println(rank);
        
    }



}
