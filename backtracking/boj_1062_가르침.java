package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1062_가르침 {

    static int N, K;
    static String[] words;
    static boolean[] alphabet;
    static Integer MAX = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        alphabet = new boolean[26];
        alphabet['a' - 'a'] = true;
        alphabet['c' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;

        words = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        backtracking(0, 0);
        System.out.println(MAX);

    }

    private static void backtracking(int alpha, int length) {
        if (length == K - 5) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!alphabet[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
            MAX = Math.max(MAX, cnt);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (alphabet[i] == false) {
                alphabet[i] = true;
                backtracking(i, length + 1);
                alphabet[i] = false;
            }
        }
    }
}
