package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        int[] arr = new int[1001];
        Eratosth(arr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(arr[temp] != 0)
                result++;
        }
        System.out.println(result);
    }

    private static void Eratosth(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }
    }

}
