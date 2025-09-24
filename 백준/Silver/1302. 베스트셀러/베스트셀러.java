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
        Map<String, Integer> bookMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            bookMap.put(bookName, bookMap.getOrDefault(bookName, 0) + 1);
        }
        int maxCount = Collections.max(bookMap.values());
        List<String> result = bookMap.entrySet()
                                     .stream()
                                     .filter(entry -> entry.getValue() == maxCount)
                                     .map(Map.Entry::getKey)
                                     .sorted()
                                     .collect(Collectors.toList());

        bw.write(result.get(0) + "");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}