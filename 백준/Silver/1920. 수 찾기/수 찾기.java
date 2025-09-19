import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Long> unique = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            unique.add(Long.parseLong(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Long> compareList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            compareList.add(Long.parseLong(st.nextToken()));
        }

        for (long l : compareList) {
            if (unique.contains(l)) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}