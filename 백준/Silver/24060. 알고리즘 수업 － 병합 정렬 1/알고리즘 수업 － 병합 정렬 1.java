import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int answer = -1;
    private static int K;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N - 1);
        System.out.println(answer);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int l1 = mid - left + 1;
        int l2 = right - mid;

        int[] L = new int[l1];
        for (int i = 0; i < l1; i++) {
            L[i] = arr[left + i];
        }
        int[] R = new int[l2];
        for (int i = 0; i < l2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int l = 0, r = 0;
        while (l < l1 && r < l2) {
            if (L[l] < R[r]) {
                arr[left++] = L[l];
                count++;
                if (count == K) {
                    answer = L[l];
                }
                l++;
            } else {
                arr[left++] = R[r];
                count++;
                if (count == K) {
                    answer = R[r];
                }
                r++;
            }
        }

        while (l < l1) {
            arr[left++] = L[l];
            count++;
            if (count == K) {
                answer = L[l];
            }
            l++;
        }

        while (r < l2) {
            arr[left++] = R[r];
            count++;
            if (count == K) {
                answer = R[r];
            }
            r++;
        }
    }
}
