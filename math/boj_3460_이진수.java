package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3460_이진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            while (n > 0) {
                if (n % 2 != 0) {
                    System.out.print(cnt + " ");
                }
                n = n / 2;
                cnt++;
            }
            System.out.println();
        }
    }
}
