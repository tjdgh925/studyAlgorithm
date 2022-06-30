package backtracking;

import java.io.*;
import java.util.*;

public class boj_15650_N과M2 {

    static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        solution(1, 0);
        System.out.println(sb);
    }

    private static void solution(int start, int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {

            arr[depth] = i;
            solution(i + 1, depth + 1);
        }
    }
}


