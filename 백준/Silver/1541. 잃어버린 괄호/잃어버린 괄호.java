import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        int len = list.size();
        int result = 0;
        if (len > 0) {
            result += calculateAddString(list.get(0));
            for (int i = 1; i < len; i++) {
                result -= calculateAddString(list.get(i));
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public int calculateAddString(String str) {
        int result = 0;
        StringTokenizer st = new StringTokenizer(str, "+");
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}