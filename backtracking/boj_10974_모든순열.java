package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10974_모든순열 {

    static int N;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N];

        back(0);
        System.out.println(sb);
    }

    private static void back(int depth) {
        if (depth == N) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i - 1]) {
                visit[i - 1] = true;
                arr[depth] = i;
                back(depth + 1);
                visit[i - 1] = false;
            }
        }
    }
}
