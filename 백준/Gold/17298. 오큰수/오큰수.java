import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(arr, N));
	}

	static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();

		Deque<Integer> stack = new ArrayDeque<>();
		int[] ans = new int[n];

		int p = n - 1;
		while (p >= 0) {
			while (!stack.isEmpty() && stack.peek() <= arr[p]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans[p] = -1;
			} else {
				ans[p] = stack.peek();
			}

			stack.push(arr[p]);
			p--;
		}

		for (int a : ans) {
			sb.append(a).append(" ");
		}

		return sb.toString();
	}
}
