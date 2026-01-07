import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M;
    static int[][] graph;
    static int answer = 0;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y}); //시작점 초기화

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;;
                if(graph[nx][ny] == 0) continue;
                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }

        }

        return graph[N-1][M-1];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
