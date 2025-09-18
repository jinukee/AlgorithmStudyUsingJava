import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public boolean solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Main().solution());
    }
}