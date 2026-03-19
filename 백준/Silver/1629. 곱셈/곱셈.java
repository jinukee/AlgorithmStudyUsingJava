import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(getMod(A, B, C));
    }

    private static long getMod(int A, int B, int C) {
        if (B == 1) {
            return A % C;
        }

        if (B % 2 == 0) {
            long half = getMod(A, B / 2, C);
            return (half * half) % C;
        }
        return ((A % C) * getMod(A, B - 1, C)) % C;
    }
}
