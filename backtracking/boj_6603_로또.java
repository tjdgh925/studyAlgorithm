package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_로또 {

    static int K;
    static int[] S;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            S = new int[K];
            visit = new boolean[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            solution(0,0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void solution(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (visit[i]) {
                    sb.append(S[i]).append(' ');
                }
            }
            sb.append('\n');

        }
        for (int i = start; i < K; i++) {
            visit[i] = true;
            solution(i + 1, depth + 1);
            visit[i] = false;
        }
    }
}
