import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX_PROBLEM_COUNT = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // idx : problem number, value : difficulty
        int[] difficulties = new int[MAX_PROBLEM_COUNT + 1];
        // keys are sorted by difficulty, values are sorted by problem number
        TreeMap<Integer, TreeSet<Integer>> difficultyMap = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int pNum = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());

            difficulties[pNum] = difficulty;

            if (!difficultyMap.containsKey(difficulty)) {
                difficultyMap.put(difficulty, new TreeSet<>());
            }
            difficultyMap.get(difficulty).add(pNum);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                int pNum = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());

                difficulties[pNum] = difficulty;

                if (!difficultyMap.containsKey(difficulty)) {
                    difficultyMap.put(difficulty, new TreeSet<>());
                }
                difficultyMap.get(difficulty).add(pNum);
            } else if (command.equals("recommend")) {
                int flag = Integer.parseInt(st.nextToken());
                if (flag == -1) {
                    sb.append(difficultyMap.get(difficultyMap.firstKey()).first()).append("\n");
                } else {
                    sb.append(difficultyMap.get(difficultyMap.lastKey()).last()).append("\n");
                }
            } else {
                int pNum = Integer.parseInt(st.nextToken());
                int difficulty = difficulties[pNum];

                difficultyMap.get(difficulty).remove(pNum);
                if (difficultyMap.get(difficulty).isEmpty()) {
                    difficultyMap.remove(difficulty);
                }
            }
        }

        System.out.print(sb);
    }
}
