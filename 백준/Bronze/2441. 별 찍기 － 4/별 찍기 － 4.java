import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		makeStar(N);
		System.out.print(sb);
		br.close();
	}

	static void makeStar(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < i; k++) {
				sb.append(" ");
			}
			for (int j = 0; j < n - i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
	}
}
