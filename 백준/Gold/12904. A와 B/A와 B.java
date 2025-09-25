import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        String str = br.readLine();
        bw.write(canConvert(target, str) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public int canConvert(String target, String str) {
        while (str.length() != target.length()) {
            int len = str.length();
            if (str.charAt(len - 1) == 'A') {
                str = str.substring(0, len - 1);
            } else {
                str = new StringBuilder(str.substring(0, len - 1)).reverse().toString();
            }
        }
        if (target.equals(str)) return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}