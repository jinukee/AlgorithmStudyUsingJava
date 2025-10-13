import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(gcd(a, b)));
        bw.write("\n");
        bw.write(String.valueOf(lcm(a, b)));
        bw.flush();
        br.close();
        bw.close();
    }

    // 유클리드 호제법 : a > b 일때 a 와 b의 gcd 는 b 와 a 를 b로 나눈 나머지 r의 gcd와 같다.
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
