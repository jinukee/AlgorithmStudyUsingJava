import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int answer = 1;
        int maxHeight = 1;

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(height, maxHeight);
                graph[i][j] = height;
            }
        }

        for (int h = 1; h < maxHeight; h++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    count += dfs(x, y, h);
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
        br.close();
    }

    private static int dfs(int x, int y, int height) {
        if (visited[x][y] || graph[x][y] <= height) {
            return 0;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
        return 1;
    }
}
