package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1292_쉽게푸는문제 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[1001];
        int sum = 0;
        createSequence(arr);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    private static void createSequence(int[] arr) {
        int cnt = 1;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (cnt == 1001) {
                    break;
                }
                arr[cnt] = i;
                cnt++;
            }
        }
    }
}
