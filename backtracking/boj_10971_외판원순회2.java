package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10971_외판원순회2 {

    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            solve(i, i, 0, 0);
        }
        System.out.println(result);
    }

    private static void solve(int start, int now, int count, int sum) {
        if (count == N - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                result = Math.min(result, sum);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visit[i] && arr[now][i] > 0){
                visit[i] = true;
                solve(start, i, count+1, sum + arr[now][i]);
                visit[i] = false;
            }
        }
    }
}
