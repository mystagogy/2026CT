import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] graph;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();
    static int sum = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(true){
            visited = new boolean[N][N];
            boolean moved = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]) {

                        list.clear();
                        sum = 0;

                        dfs(i, j);

                        if(list.size() > 1) {
                            calcGraph();
                            moved = true;
                        }
                    }
                }
            }
            if (!moved) break;
            days++;
        }

        System.out.print(days);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        list.add(new int[]{x,y});
        sum += graph[x][y];

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(!visited[nx][ny]) {
                    int diff = Math.abs(graph[x][y] - graph[nx][ny]);
                    if(diff >= L && diff <= R) dfs(nx, ny);
                }
            }
        }
    }

    static void calcGraph() {
        int avg = sum / list.size();
        for(int[] arr : list) {
            graph[arr[0]][arr[1]] = avg;
        }
    }


}
