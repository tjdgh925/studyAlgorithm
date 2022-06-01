package sorting;

import java.io.*;
import java.util.*;

public class boj_2252_줄세우기 {

    static int N, M;
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] degree;
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr.get(A).add(B);
            degree[B]++;
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                que.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            int n = que.poll();

            System.out.print(n+" ");
            for (Integer a : arr.get(n)) {
                if (--degree[a] == 0) {
                    que.add(a);
                }
            }
        }

    }
}
