import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;
    int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
public class Main {
    static int N, M, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue = new LinkedList<>();
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                    if (box[z][x][y] == 1) {
                        queue.offer(new Tomato(x, y, z));
                    }
                }
            }
        }
        bfs();

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (box[z][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            int x = current.x;
            int y = current.y;
            int z = current.z;

            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = box[z][x][y] + 1;
                        answer = Math.max(answer, box[nz][nx][ny]);
                        queue.offer(new Tomato(nx, ny, nz));
                    }
                }
            }
        }
    }

}
