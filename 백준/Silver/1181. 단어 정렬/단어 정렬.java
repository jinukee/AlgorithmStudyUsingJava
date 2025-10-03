import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> strSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            strSet.add(br.readLine());
        }

        List<String> resultList = strSet.stream().sorted((s1, s2) -> {
            int result = s1.length() - s2.length();
            result = (result == 0) ? s1.compareTo(s2) : result;
            return result;
        }).collect(Collectors.toList());

        int len = resultList.size();
        for (int i = 0; i < len; i++) {
            bw.write(resultList.get(i) + "\n");
        }

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}