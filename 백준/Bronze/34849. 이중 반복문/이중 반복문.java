import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final int LIMIT = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if ((long) N * N <= LIMIT) {
            System.out.println("Accepted");
        } else {
            System.out.println("Time limit exceeded");
        }
    }
}
