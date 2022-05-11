package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] oper = new int[4];
    static int numbers[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int index) {
        if (index == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                if (i == 0)
                    dfs(num + numbers[index], index + 1);
                else if (i == 1)
                    dfs(num - numbers[index], index + 1);
                else if (i == 2)
                    dfs(num * numbers[index], index + 1);
                else if (i == 3)
                    dfs(num / numbers[index], index + 1);

                oper[i]++;
            }
        }
    }
}

