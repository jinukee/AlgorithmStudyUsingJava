import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long serial = 666;
        int count = 1;

        while (count++ < N) {
            while (true) {
                serial++;
                if (String.valueOf(serial).contains("666")) {
                    break;
                }
            }
        }

        System.out.println(serial);
        br.close();
    }
}
