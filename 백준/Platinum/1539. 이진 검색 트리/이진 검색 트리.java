import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // value, depth
        TreeSet<Integer> ts = new TreeSet<>();
        int[] depth = new int[N];

        long ans = 0L;

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            Integer lower = ts.lower(now);
            Integer higher = ts.higher(now);

            int nowDepth = 0;

            if (lower == null && higher == null) {
                nowDepth = 1; // root
            } else if (lower == null) {
                nowDepth = depth[higher] + 1; // put now into successor's left child
            } else if (higher == null) {
                nowDepth = depth[lower] + 1; // put now into predecessor's right child
            } else {
                nowDepth = Math.max(depth[lower], depth[higher]) + 1; // compare both successor's depth and predecessor's depth
            }

            ans += nowDepth;
            ts.add(now);
            depth[now] = nowDepth;
        }

        System.out.println(ans);
    }
}
