import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= 1000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 1000; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		while (N-- > 0) {
			if (isPrime[Integer.parseInt(st.nextToken())]) {
				result++;
			}
		}

		System.out.print(result);
	}
}
