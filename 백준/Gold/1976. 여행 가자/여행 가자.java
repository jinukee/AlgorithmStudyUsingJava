import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        System.out.println(solution(br.readLine(), M));
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        parents[find(x)] = parents[find(y)];
    }

    private static String solution(String path, int M) {
        StringTokenizer st = new StringTokenizer(path);

        int curr = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(curr) != find(next)) {
                return "NO";
            }
            curr = next;
        }

        return "YES";
    }
}
