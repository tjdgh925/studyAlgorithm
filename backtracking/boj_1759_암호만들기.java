package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_암호만들기 {
    static int L, C;
    static char[] code;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        code = new char[C];
        result = new int[C];
        for (int i = 0; i < C; i++) {
            code[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(code);

        dfs(0, 0, 0, 0);
    }

    private static void dfs(int start, int depth, int j, int m) {
        for (int i = start; i < C; i++) {
            result[i] = 1;
            dfs(i + 1, depth + 1, j + (!check(code[i]) ? 1 : 0), m + (!check(code[i]) ? 0 : 1));

            result[i] = 0;
        }
        if (depth == L && j >= 2 && m >= 1) {
            print();
        }
    }

    public static void print() {
        for (int i = 0; i < C; i++) {
            // result가 0이라면 선택되지 않았기 때문에 넘긴다.
            if (result[i] == 1)
                System.out.print(code[i]);
        }
        System.out.println();
    }

    public static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        else
            return false;
    }
}
