import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = 0;

		while (N != 0) {
			if (N % 5 == 0) {
				result += N / 5;
				System.out.println(result);
				return;
			} else {
				if (N < 3) {
					System.out.println(-1);
					return;
				}
				N -= 3;
				result++;
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
