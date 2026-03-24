import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = Arrays.stream(target).distinct().sorted().toArray();

        for (int i = 0; i < N; i++) {
            sb.append(lower(arr, target[i])).append(" ");
        }
        System.out.print(sb);
    }

    private static int lower(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
