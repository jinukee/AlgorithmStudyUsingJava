import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int L, C;
    private static char[] input, out;
    private static final StringBuilder sb = new StringBuilder();
    private static final Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        out = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        choose(0, 0, 0);
        System.out.print(sb);
    }

    private static void choose(int start, int depth, int vowelCount) {
        if (depth == L) {
            if (vowelCount >= 1 && L - vowelCount >= 2) {
                sb.append(out).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            out[depth] = input[i];
            int nextCount = vowelCount;
            if (vowels.contains(input[i])) {
                nextCount++;
            }

            choose(i + 1, depth + 1, nextCount);
        }
    }
}
