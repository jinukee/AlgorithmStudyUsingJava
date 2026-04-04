import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = (int)1e8;
	static int N;
	static List<Node>[] adj;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adj[u].add(new Node(v, cost));
		}

		st = new StringTokenizer(br.readLine());
		System.out.println(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	}

	static int dijkstra(int from, int to) {
		dist[from] = 0;
		Queue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(from, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.idx] < cur.cost) {
				continue;
			}

			for (Node neighbor : adj[cur.idx]) {
				int newCost = cur.cost + neighbor.cost;
				if (dist[neighbor.idx] > newCost) {
					dist[neighbor.idx] = newCost;
					pq.offer(new Node(neighbor.idx, newCost));
				}
			}
		}

		return dist[to];
	}
}
