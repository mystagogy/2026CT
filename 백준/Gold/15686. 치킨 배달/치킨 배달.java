import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] graph;
    static boolean[] visited;
    static List<int[]> homeList;
    static List<int[]> chickenList;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int x = Integer.parseInt(st.nextToken());
                graph[i][j] = x;
                if(x == 1) homeList.add(new int[]{i,j});
                else if(x == 2) chickenList.add(new int[]{i,j});
            }
        }

        visited = new boolean[chickenList.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int idx, int cnt){
        if(cnt == M){ //종료 조건
            int sum = 0;
            for(int[] h : homeList){
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < chickenList.size(); i++){
                    if(visited[i]) min = Math.min(min, Math.abs(h[0] - chickenList.get(i)[0]) + Math.abs(h[1] - chickenList.get(i)[1]));
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;

        }

        for(int i = idx; i < chickenList.size(); i++) { // 치킨집 리스트 중 M개 뽑기
            visited[i] = true;
            dfs(i+1, cnt+1);
            visited[i] = false;
        }
    }
}
