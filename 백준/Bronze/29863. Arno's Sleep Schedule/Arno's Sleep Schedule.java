import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int night = Integer.parseInt(br.readLine());
        int morning = Integer.parseInt(br.readLine());

        int ans = night <= 3 ? morning - night : morning + 24 - night;
        System.out.println(ans);
    }
}
