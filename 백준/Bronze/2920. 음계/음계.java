import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(arr));
	}

	private static String solution(int[] arr) {
		if (isAscending(arr)) {
			return "ascending";
		} else if (isDescending(arr)) {
			return "descending";
		}
		return "mixed";
	}

	private static boolean isAscending(int[] arr) {
		for (int i = 1; i < 8; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDescending(int[] arr) {
		for (int i = 1; i < 8; i++) {
			if (arr[i] > arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
