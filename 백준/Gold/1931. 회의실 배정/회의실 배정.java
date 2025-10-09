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
        StringTokenizer st;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> li = new ArrayList<>();
            while (st.hasMoreTokens()) li.add(Integer.parseInt(st.nextToken()));
            list.add(li);
        }

        Collections.sort(list, (l1, l2) -> {
            int result = Integer.compare(l1.get(1), l2.get(1));
            result = (result == 0) ? Integer.compare(l1.get(0), l2.get(0)) : result;
            return result;
        });

        int result = 0;
        int end = 0;
        for (List<Integer> li : list) {
            if (li.get(0) >= end) {
                result++;
                end = li.get(1);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}