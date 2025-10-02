import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (!(str = br.readLine()).equals("0")) {
            bw.write(isPelindrome(str));
            bw.flush();
        }
        br.close();
        bw.close();
    }

    public String isPelindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return "no\n";
        }
        return "yes\n";
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}