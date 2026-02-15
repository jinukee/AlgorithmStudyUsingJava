import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = 1;
            int room = 1;
            while (N-- > 1) {
                if (floor == H) {
                    floor = 1;
                    room++;
                } else {
                    floor++;
                }
            }

            sb.append(floor);
            if (room < 10) {
                sb.append(0);
            }
            sb.append(room).append("\n");
        }

        System.out.print(sb);
    }
}
