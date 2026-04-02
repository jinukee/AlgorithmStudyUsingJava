import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000_000_007;
    static int N;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int T = M + K;

        arr = new int[N];
        tree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        build(1, 0, N - 1);

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 0, N - 1, b - 1, c);
            } else {
                sb.append(getMul(1, 0, N - 1, b - 1, c - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    // arr idx start ~ end 까지의 곱을 tree[node] 에 저장하는 method.
    static long build(int node, int start, int end) {
        // base case
        if (start == end) {
            return tree[node] = arr[start] % MOD;
        }

        int mid = (start + end) / 2;
        return tree[node] = (build(node * 2, start, mid) % MOD
                * build(node * 2 + 1, mid + 1, end) % MOD) % MOD;
    }

    // 현재 tree[node] 는 start ~ end 까지의 누적 곱을 저장하고 있음.
    // left ~ right 사이의 누적 곱을 반환
    static long getMul(int node, int start, int end, int left, int right) {
        // 범위에 속하지 않으면 1을 반환해야함
        if (end < left || start > right) {
            return 1;
        }

        // 범위 안에 완전히 속하면 그대로 반환
        if (left <= start && end <= right) {
            return tree[node];
        }

        // 걸쳐 있다면 분할해서 반복
        int mid = (start + end) / 2;
        return (getMul(node * 2, start, mid, left, right)
                * getMul(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }

    static long update(int node, int start, int end, int index, int newValue) {
        if (start == end) { // == index
            return tree[node] = newValue;
        }

        // 절반으로 분할
        int mid = (start + end) / 2;

        // left child에 속하면 right child는 update 필요가 없음.
        if (index <= mid) {
            tree[node] = (update(node * 2, start, mid, index, newValue) * tree[node * 2 + 1]) % MOD;
        } else { // 동일.
            tree[node] = (tree[node * 2] * update(node * 2 + 1, mid + 1, end, index, newValue)) % MOD;
        }

        return tree[node];
    }
}
