import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		choose(0, 0, arr, new int[K]);
		System.out.println(sb);
	}

	static void choose(int depth, int now, int[] arr, int[] out) {
		if (depth == K) {
			for (int n : out) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = now; i < N; i++) {
			out[depth] = arr[i];
			choose(depth + 1, i + 1, arr, out);
		}
	}
}
