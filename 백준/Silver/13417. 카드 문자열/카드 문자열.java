import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> deque;
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int M =  Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            deque.offerLast(st.nextToken().charAt(0));
            for(int j = 0; j < M - 1; j++){
                char next = st.nextToken().charAt(0);
                if (next > deque.peekFirst()) {
                    deque.offerLast(next);
                }else{
                    deque.offerFirst(next);
                }
            }
            for (int j = 0; j < M; j++) {
                bw.write(deque.pollFirst());
            }
            bw.write("\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}