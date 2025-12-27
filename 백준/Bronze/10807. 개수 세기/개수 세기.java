import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) == target){
				result++;
			}
		}

		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
