import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        char c;
        if (N >= 90) c = 'A';
        else if (N >= 80) c = 'B';
        else if (N >= 70) c = 'C';
        else if (N >= 60) c = 'D';
        else c = 'F';

        bw.write(String.valueOf(c));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}