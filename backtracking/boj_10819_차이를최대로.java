package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10819_차이를최대로 {

    static int N;
    static int[] arr;
    static int[] temp;
    static boolean[] visit;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        visit = new boolean[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        System.out.println(result);
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            result = Math.max(result, calculate(temp));
        } else {
            for (int i = 0; i < N; i++) {
                if(!visit[i]){
                    visit[i] = true;
                    temp[depth] = arr[i];
                    backtracking(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    private static int calculate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            sum += Math.abs(a - b);
        }
        return sum;
    }
}
