import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int len = input.length();
        boolean[] lightBulb = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            lightBulb[i + 1] = input.charAt(i) == 'Y';
        }

        int result = 0;
        for (int i = 1; i <= len; i++) {
            if (lightBulb[i]) {
                for (int j = 1; j * i <= len; j++) {
                    lightBulb[j * i] = !lightBulb[j * i];
                }
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
