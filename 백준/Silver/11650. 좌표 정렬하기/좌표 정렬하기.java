import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                li.add(Integer.parseInt(st.nextToken()));
            }
            list.add(li);
        }

        Collections.sort(list, (l1, l2) -> {
            int result = Integer.compare(l1.get(0), l2.get(0));
            result = result == 0 ? Integer.compare(l1.get(1), l2.get(1)) : result;
            return result;
        });

        for (List<Integer> li : list) {
            bw.write(String.valueOf(li.get(0)));
            bw.write(" ");
            bw.write(String.valueOf(li.get(1)));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}