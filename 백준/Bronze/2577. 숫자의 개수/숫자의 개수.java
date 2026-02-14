import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] counts = new int[10];
        int multiple = A * B * C;

        while (multiple > 0) {
            counts[multiple % 10]++;
            multiple /= 10;
        }

        for (int count : counts) {
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
