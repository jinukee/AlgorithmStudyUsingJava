import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int result = 0;

        for (int i = 0; i < target.length() - 1; i++) {
            result = Math.max(result, getMaxLPS(target.substring(i)));
        }
        System.out.println(result);
    }

    private static int getMaxLPS(String target) {
        int len = target.length();
        int[] lps = new int[len];

        int j = 0;
        int i = 1;
        int result = 0;

        while (i < len) {
            if (target.charAt(j) == target.charAt(i)) {
                lps[i] = ++j;
                result = Math.max(result, lps[i]);
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return result;
    }
}
