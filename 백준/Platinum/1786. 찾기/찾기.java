import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();

        List<Integer> result = kmpSearch(text, pattern);
        sb.append(result.size()).append("\n");
        for (int n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] getLPS(String pattern) {
        int len = pattern.length();
        int[] lps = new int[len];

        int j = 0;
        int i = 1;

        while (i < len) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }

    private static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] lps = getLPS(pattern);

        int ti = 0;
        int pi = 0;

        while (ti < text.length()) {
            if (text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            }
            if (pi == pattern.length()) {
                result.add(ti - pi + 1);
                pi = lps[pi - 1];
            } else if (ti < text.length() && text.charAt(ti) != pattern.charAt(pi)) {
                if (pi != 0) {
                    pi = lps[pi - 1];
                } else {
                    ti++;
                }
            }
        }
        return result;
    }
}
