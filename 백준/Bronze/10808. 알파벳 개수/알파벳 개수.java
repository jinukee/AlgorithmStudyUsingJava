import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int[] result = new int[26];
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            result[input.charAt(i) - 'a']++;
        }
        for (int count : result) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}
