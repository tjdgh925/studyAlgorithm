package sorting;

import java.io.*;
import java.util.*;

public class boj_1516_게임개발 {

    static int N;
    static ArrayList<ArrayList<Integer>> arr;
    static Queue<Integer> queue;
    static int[] time;
    static int[] result;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        time = new int[N + 1];
        degree = new int[N + 1];
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }
                arr.get(num).add(i);
                degree[i]++;

            }
        }


        queue = new LinkedList<>();
        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer i : arr.get(node)) {
                result[i] = Math.max(result[i], result[node] + time[i]);
                degree[i]--;

                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            System.out.println(result[i]);
        }
    }
}
