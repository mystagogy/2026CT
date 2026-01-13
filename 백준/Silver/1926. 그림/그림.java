import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][]visited;
    static int cnt = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0 , 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i,j);
                    result = Math.max(result, size);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(result);
    }

    static int dfs(int x, int y){
        visited[x][y] = true;
        int size = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1 && !visited[nx][ny]){
                size += dfs(nx, ny);
            }
        }
        return size;
    }
}
