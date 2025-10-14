import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String x = br.readLine();
        String y = br.readLine();
        String z = br.readLine();

        bw.write(String.valueOf(Integer.parseInt(x) + Integer.parseInt(y) - Integer.parseInt(z)));
        bw.write("\n");
        bw.write(String.valueOf(Integer.parseInt(x+y) - Integer.parseInt(z)));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
