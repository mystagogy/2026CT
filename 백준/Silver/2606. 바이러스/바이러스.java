import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,M;
    static boolean[][] graph;
    static boolean[] visit;
    static int answer;

    static void dfs(int index){
        visit[index] = true;
        for(int j = 1; j <= N; j++){
            if(graph[index][j] && !visit[j]){
                answer++;
                dfs(j);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        answer = 0;
        for(int i = 0; i < M; i++){
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        System.out.print(answer);
    }
}
