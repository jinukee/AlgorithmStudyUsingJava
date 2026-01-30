import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(solution(A, B));
		br.close();
	}

	private static int solution(int A, int B) {
		int count = 0;

		while (B > A) {
			if (B % 2 == 0) {
				B /= 2;
				count++;
				continue;
			}
			if (B % 10 != 1) {
				return -1;
			}
			B /= 10;
			count++;
		}
		if (B != A) {
			return -1;
		}
		return count + 1;
	}
}
