import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y, broken;

        public Node(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int x = cur.x;
            int y = cur.y;
            int broken = cur.broken;

            if (x == N - 1 && y == M - 1) {
                return dist[x][y][broken];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈 칸으로 이동
                if (map[nx][ny] == 0 && dist[nx][ny][broken] == 0) {
                    dist[nx][ny][broken] = dist[x][y][broken] + 1;
                    q.offer(new Node(nx, ny, broken));
                }

                // 벽이고, 아직 안 부쉈다면 한 번 부수고 이동
                if (map[nx][ny] == 1 && broken == 0 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    q.offer(new Node(nx, ny, 1));
                }
            }
        }

        return -1;
    }
}