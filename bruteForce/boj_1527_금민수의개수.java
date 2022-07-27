package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1527_금민수의개수 {

    static int A, B;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(long num) {
        if (num > B)
            return;
        if (num >=A && num <=B) answer++;

        dfs(num* 10 + 4);
        dfs(num* 10 + 7);
    }
}
