import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), 0);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String student = st.nextToken();
                map.put(student, map.get(student) + 1);
            }
        }

        List<Map.Entry<String, Integer>> result = map.entrySet().stream().collect(Collectors.toList());
        result.sort((e1, e2) -> {
            int compare = e1.getValue().compareTo(e2.getValue());
            if (compare == 0) return e1.getKey().compareTo(e2.getKey());
            return -compare;
        });
        for (Map.Entry<String, Integer> entry : result) {
            bw.write(entry.getKey() + " ");
            bw.write(entry.getValue() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}