import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        List<String> layers = new ArrayList<>();
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for (int i = 0; i < N; i++) {
            layers.add(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            if (!canStack(layers.get(i), layers.get(i + 1), M)) return 0;
        }
        return 1;
    }

    public boolean canStack(String cur, String next, int len) {
        for (int i = 0; i < len; i++) {
            if (cur.substring(0, i + 1).equals(next.substring(len - i - 1, len)) || next.substring(0, i + 1).equals(cur.substring(len - i - 1, len)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Main().solution());
    }
}