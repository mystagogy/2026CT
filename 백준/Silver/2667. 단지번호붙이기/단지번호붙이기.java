import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int[][] graph;
    static boolean[][] visit;
    static int total;
    static int count;
    static int[] dx = {-1, 1 , 0, 0};
    static int[] dy = {0, 0 , 1, -1};

    static void dfs(int x, int y){
        visit[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(graph[nx][ny] == 1 && !visit[nx][ny]) dfs(nx, ny);
            }
        }
    }
    public static void main(String[]  args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visit = new boolean[N][N];
        total = 0; //  총 단지 수
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < N; j++){
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 1 && !visit[i][j]){
                    count = 0;
                    dfs(i, j);
                    total++;
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");
        for(int x : list) sb.append(x).append("\n");
        System.out.print(sb);
    }
}
