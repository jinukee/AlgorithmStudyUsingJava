import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static final Node[] nodes = new Node[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char value = input.charAt(0);
            char left = input.charAt(2);
            char right = input.charAt(4);

            if (nodes[value - 'A'] == null) {
                nodes[value - 'A'] = new Node(value);
            }
            Node now = nodes[value - 'A'];
            if (left != '.') {
                if (nodes[left - 'A'] == null) {
                    nodes[left - 'A'] = new Node(left);
                }
                now.left = nodes[left - 'A'];
            }
            if (right != '.') {
                if (nodes[right - 'A'] == null) {
                    nodes[right - 'A'] = new Node(right);
                }
                now.right = nodes[right - 'A'];
            }
        }

        Node root = nodes[0];
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);
    }

    private static void preOrder(Node now) {
        if (now == null) {
            return;
        }
        sb.append(now.value);
        preOrder(now.left);
        preOrder(now.right);
    }

    private static void inOrder(Node now) {
        if (now == null) {
            return;
        }
        inOrder(now.left);
        sb.append(now.value);
        inOrder(now.right);
    }

    private static void postOrder(Node now) {
        if (now == null) {
            return;
        }
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.value);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}
