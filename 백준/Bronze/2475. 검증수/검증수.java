import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		for (int i = 0; i < 5; i++) {
			int now = Integer.parseInt(st.nextToken());
			result = (result + (now * now) % 10) % 10;
		}
		System.out.println(result);
	}
}
