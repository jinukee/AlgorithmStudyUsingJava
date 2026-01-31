import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] adj;
	private static boolean[][] visited;
	private static final int[] DX = {1, -1, 0, 0};
	private static final int[] DY = {0, 0, 1, -1};
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int max = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				int res = bfs(x, y);
				if (res != 0) {
					count++;
					max = Math.max(res, max);
				}
			}
		}

		sb.append(count).append("\n").append(max);
		System.out.println(sb);
		br.close();
	}

	private static int bfs(int x, int y) {
		if (adj[x][y] != 1 || visited[x][y]) {
			return 0;
		}

		int count = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + DX[i];
				int ny = now[1] + DY[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && adj[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					count++;
					q.offer(new int[] {nx, ny});
				}
			}
		}

		return count;
	}
}
