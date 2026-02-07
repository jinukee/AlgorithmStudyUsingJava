import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			long n = Long.parseLong(br.readLine());
			while (true) {
				if(isPrime(n)) {
					sb.append(n).append("\n");
					break;
				}
				n++;
			}
		}
		System.out.print(sb);
	}

	private static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}
		for (long i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
