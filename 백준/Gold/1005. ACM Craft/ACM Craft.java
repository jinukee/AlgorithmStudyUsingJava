import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adj;
	static int N;
	static int[] indegree;
	static int[] cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			adj = new ArrayList[N + 1];
			indegree = new int[N + 1];
			cost = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				adj[u].add(v);
				indegree[v]++;
			}

			int W = Integer.parseInt(br.readLine());

			Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // nodeIdx, endTime
			// 매 단계마다 동시에 진행할 수 있는 작업 중 가장 마지막에 끝나는 작업에 이어서 다음 작업 시간을 계산해줘야함.
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					q.offer(new int[] { i, cost[i] });
				}
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (cur[0] == W) {
					sb.append(cur[1]).append("\n");
					break;
				}

				for (int neighbor : adj[cur[0]]) {
					if (--indegree[neighbor] == 0) {
						q.offer(new int[] { neighbor, cur[1] + cost[neighbor] });
					}
				}
			}

		}
		System.out.print(sb);
	}
}
