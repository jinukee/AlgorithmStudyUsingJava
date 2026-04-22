import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (N > 0 && B > 0) {
            B--;
            cnt++;
            N--;
        }

        while (N > 0 && A >= 2) {
            A -= 2;
            cnt++;
            N--;
        }

        System.out.println(cnt);
    }
}
