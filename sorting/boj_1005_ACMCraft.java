package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1005_ACMCraft {

    static int T, N, K;
    static int[] time;
    static int[] result;
    static int[] degree;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            List<List<Integer>> arr = new ArrayList<List<Integer>>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= N; j++) {
                arr.add(new ArrayList<Integer>());
            }

            time = new int[N + 1];
            degree = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }


            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr.get(X).add(Y);
                degree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());
            result = new int[N + 1];

            for (int j = 1; j <= N; j++) {
                result[j] = time[j];

                if (degree[j] == 0) {
                    que.add(j);
                }
            }

            while (!que.isEmpty()) {
                int node = que.poll();

                for (Integer a : arr.get(node)) {
                    result[a] = Math.max(result[node] + time[a], result[a]);
                    degree[a]--;
                    if (degree[a] == 0) {
                        que.add(a);
                    }
                }
            }
            System.out.println(result[W]);
        }
    }
}
