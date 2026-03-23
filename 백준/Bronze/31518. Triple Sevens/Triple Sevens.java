import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (!hasSeven(input, N)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(777);
    }

    private static boolean hasSeven(String input, int n) {
        StringTokenizer st = new StringTokenizer(input);
        while (n-- > 0) {
            if (Integer.parseInt(st.nextToken()) == 7) {
                return true;
            }
        }

        return false;
    }
}
