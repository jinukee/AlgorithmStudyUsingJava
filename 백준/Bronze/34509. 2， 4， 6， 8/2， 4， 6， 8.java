import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 10; i <= 99; i++) {
            if (match(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    static boolean match(int n) {
        String strN = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i >= 0; i--) {
            int cur = strN.charAt(i) - '0';
            if (cur == 8) {
                return false;
            }
            sum += cur;
            sb.append(cur);
        }
        if (sum % 6 != 0) {
            return false;
        }

        return Integer.parseInt(sb.toString()) % 4 == 0;
    }
}
