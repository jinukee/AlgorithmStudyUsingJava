import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            System.out.println(Arrays.stream(str.split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .sum());
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}