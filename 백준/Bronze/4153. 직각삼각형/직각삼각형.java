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
        StringTokenizer st;
        String str;
        List<Integer> li;
        while (!(str=br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(str);
            li = new ArrayList<>();
            li.add(Integer.parseInt(st.nextToken()));
            li.add(Integer.parseInt(st.nextToken()));
            li.add(Integer.parseInt(st.nextToken()));
            Collections.sort(li);
            if(Math.pow(li.get(0),2) + Math.pow(li.get(1),2) == Math.pow(li.get(2),2)) bw.write("right\n");
            else bw.write("wrong\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}