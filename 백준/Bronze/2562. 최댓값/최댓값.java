import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int maxIndex = 1;
        for (int i = 1; i < 10; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }

        bw.write(max + "\n");
        bw.write(maxIndex + "");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}