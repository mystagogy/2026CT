import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M, x, y, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1 ,0, -1};
    static int[][] graph;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            if(graph[x][y] == 0) { //현재 칸이 청소가 되지 않은 경우
                answer++;
                graph[x][y] = 2;
            }

            boolean moved = false;
            for(int i = 0;  i < 4; i++) {
                d = (d+3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(graph[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }

            if(!moved) {
                int nDir = (d + 2) % 4;
                int nx = x + dx[nDir];
                int ny = y + dy[nDir];

                if(graph[nx][ny] == 1) break;

                x = nx;
                y = ny;
            }
        }

        System.out.println(answer);

    }

}
