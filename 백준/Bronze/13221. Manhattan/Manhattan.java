import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int closet = 201;

        int xResult = 0;
        int yResult = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            int dist = Math.abs(nx - x) + Math.abs(ny - y);

            if (dist < closet) {
                closet = dist;
                xResult = nx;
                yResult = ny;
            }
        }

        sb.append(xResult).append(" ").append(yResult);
        System.out.print(sb);
    }

}
