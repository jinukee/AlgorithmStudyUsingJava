import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);
        bw.write(set1.size() + "\n");
        for (String name : set1) {
            bw.write(name + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}