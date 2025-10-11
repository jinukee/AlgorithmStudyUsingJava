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
        List<Member> memberList = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memberList.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(memberList, (m1, m2) -> {
            int result = m1.age - m2.age;
            result = (result == 0) ? m1.registerNo - m2.registerNo : result;
            return result;
        });

        for (Member m : memberList) {
            bw.write(String.valueOf(m.age));
            bw.write(" ");
            bw.write(m.name);
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

class Member {
    int registerNo;
    int age;
    String name;

    public Member(int registerNo, int age, String name) {
        this.registerNo = registerNo;
        this.age = age;
        this.name = name;
    }
}