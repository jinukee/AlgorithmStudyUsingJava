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

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            List<Integer> studentsId = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                studentsId.add(Integer.parseInt(br.readLine()));
            }
            bw.write(getMinNum(studentsId) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public int getMinNum(List<Integer> idList) {
        int currentMin = 1;
        while (true) {
            Set<Integer> unique = new HashSet<>();
            for (int id : idList) {
                if (!unique.add(id % currentMin)) break;
            }
            if (unique.size() == idList.size()) break;
            currentMin++;
        }
        return currentMin;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}