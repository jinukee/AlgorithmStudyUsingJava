import java.io.*;
import java.util.*;

public class Main {

	static final int INF = (int)1e8;
	static int N;
	static List<Node>[] adj;
	static int[] dist;
	static int[] prev;

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
		prev = new int[N + 1];

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

	static String dijkstra(int from, int to) {
		StringBuilder sb = new StringBuilder();
		dist[from] = 0;

		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.cost > dist[cur.idx]) {
				continue;
			}

			for (Node neighbor : adj[cur.idx]) {
				int nextCost = cur.cost + neighbor.cost;
				if (nextCost < dist[neighbor.idx]) {
					dist[neighbor.idx] = nextCost;
					prev[neighbor.idx] = cur.idx;
					pq.offer(new Node(neighbor.idx, nextCost));
				}
			}
		}

		sb.append(dist[to]).append("\n");

		Deque<Integer> stack = new ArrayDeque<>();
		int now = to;
		while (now != from) {
			stack.push(now);
			now = prev[now];
		}
		stack.push(now);

		sb.append(stack.size()).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		return sb.toString();
	}
}
