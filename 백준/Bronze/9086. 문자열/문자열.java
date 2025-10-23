import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write(getFirstAndLastChar(br.readLine()));
            bw.flush();
        }
        br.close();
        bw.close();
    }

    private String getFirstAndLastChar(String str) {
        StringBuilder sb = new StringBuilder();
        int len =  str.length();
        sb.append(str.charAt(0));
        sb.append(str.charAt(len-1));
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
