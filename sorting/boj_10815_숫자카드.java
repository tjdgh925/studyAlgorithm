package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_숫자카드 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binary(num)) {
                System.out.print(1 + " ");
            } else
                System.out.print(0 + " ");
        }
    }

    private static boolean binary(int num) {
        int start = 0;
        int last = N - 1;

        while (start <= last) {
            int mid = (start + last) / 2;
            int temp = arr[mid];

            if (num < temp) {
                last = mid - 1;
            } else if (num > temp) {
                start = mid + 1;
            } else
                return true;
        }
        return false;
    }
}
