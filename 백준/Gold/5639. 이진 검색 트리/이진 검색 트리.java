import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static int[] preorder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        preorder = new int[10_000];

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            preorder[N++] = value;
        }

        getPost(0, N - 1);
        System.out.print(sb);
    }

    // postorder : 왼쪽 서브트리 -> 오른쪽 서브트리 -> 루트 순으로 출력
    private static void getPost(int start, int end) {
        // base case(재귀 탈출)
        if (start > end) {
            return;
        }

        int mid = preorder[start];

        // 분기점 (mid 보다 커지는 노드가 등장하는 index -> 이 곳이 오른쪽 서브트리의 시작점)
        int split = start + 1;
        while (split <= end && preorder[split] < mid) {
            split++;
        }

        // 왼쪽 서브트리
        getPost(start + 1, split - 1);
        // 오른쪽 서브트리
        getPost(split, end);
        sb.append(preorder[start]).append("\n");
    }
}
