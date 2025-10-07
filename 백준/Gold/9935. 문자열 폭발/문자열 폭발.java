import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String target = br.readLine();
        String bomb = br.readLine();
        char[] bombArray = bomb.toCharArray();
        int targetLen = target.length();
        int bombLen = bomb.length();
        char last = bombArray[bombLen - 1];

        for (int i = 0; i < targetLen; i++) {
            char c = target.charAt(i);
            sb.append(c);
            int sbLen = sb.length();
            if (c == last && sbLen >= bombLen) {
                boolean isbomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sbLen - bombLen + j) != bombArray[j]) {
                        isbomb = false;
                        break;
                    }
                }
                if (isbomb) {
                    sb.setLength(sbLen - bombLen);
                }
            }
        }

        if (sb.length() == 0) bw.write("FRULA");
        else bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}