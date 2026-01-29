import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static int N;
    private static int[][] adj;
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int count;

    private static final Queue<Integer> heap = new PriorityQueue<>();

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                adj[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                count = 0;
                if (dfs(x, y)) {
                    heap.offer(count);
                }
            }
        }

        sb.append(heap.size()).append("\n");
        while (!heap.isEmpty()) {
            sb.append(heap.poll()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean dfs(int x, int y) {
        if (visited[x][y] || adj[x][y] == 0) {
            return false;
        }

        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && adj[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }

        return true;
    }
}
