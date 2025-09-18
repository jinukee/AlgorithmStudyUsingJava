import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                unique.add(str.substring(i, j));
            }
        }
        return unique.size();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Main().solution());
    }
}