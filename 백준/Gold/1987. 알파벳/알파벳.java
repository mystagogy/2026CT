import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static int[][] map;
    static boolean[] alphabet = new boolean[26];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0 , 0, 1, -1};
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        alphabet[map[0][0]] = true;
        dfs(0,0, 1);

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int depth) {
        cnt = Math.max(cnt, depth);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int next = map[nx][ny];

                if(!alphabet[next]) {
                    alphabet[next] = true;
                    dfs(nx, ny, depth + 1);
                    alphabet[next] = false;
                }
            }
        }

    }
}
