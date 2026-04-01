import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static long[] tree;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int T = M + K;

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N * 4];
        build(1, 0, N - 1);

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 0, N - 1, b - 1, c);
            } else {
                sb.append(getSum(1, 0, N - 1, b - 1, (int) c - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    // start ~ end 의 구간합을 node에 저장
    static long build(int node, int start, int end) {
        // base case
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = build(node * 2, start, mid) + build(node * 2 + 1, mid + 1, end);
    }

    // left ~ right 의 구간 합을 조회
    static long getSum(int node, int start, int end, int left, int right) {
        if (end < left || start > right) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return getSum(node * 2, start, mid, left, right) + getSum(node * 2 + 1, mid + 1, end, left, right);
    }

    // index 값의 value 를 new value로 업데이트
    static long update(int node, int start, int end, int index, long newValue) {
        if (start > index || end < index) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = newValue;
        }

        int mid = (start + end) / 2;
        return tree[node] = update(node * 2, start, mid, index, newValue) + update(node * 2 + 1, mid + 1, end, index, newValue);
    }
}
