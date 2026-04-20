import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int S = 0;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int n;

            if (command.equals("add")) {
                n = Integer.parseInt(st.nextToken());
                S |= (1 << (n - 1));
            } else if (command.equals("check")) {
                n = Integer.parseInt(st.nextToken());
                if ((S & (1 << (n - 1))) == (1 << (n - 1))) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (command.equals("remove")) {
                n = Integer.parseInt(st.nextToken());
                S &= (~(1 << (n - 1)));
            } else if (command.equals("toggle")) {
                n = Integer.parseInt(st.nextToken());
                S ^= (1 << (n - 1));
            } else if (command.equals("all")) {
                S = (1 << 21) - 1;
            } else { // "empty"
                S = 0;
            }
        }

        System.out.print(sb);
    }
}
