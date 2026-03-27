import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int key = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) {
                        continue;
                    }

                    if (key == -1) {
                        int firstCount = treeMap.get(treeMap.firstKey());
                        if (firstCount > 1) {
                            treeMap.put(treeMap.firstKey(), firstCount - 1);
                        } else {
                            treeMap.remove(treeMap.firstKey());
                        }
                    } else {
                        int lastCount = treeMap.get(treeMap.lastKey());
                        if (lastCount > 1) {
                            treeMap.put(treeMap.lastKey(), lastCount - 1);
                        } else {
                            treeMap.remove(treeMap.lastKey());
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
