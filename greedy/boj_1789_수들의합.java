package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1789_수들의합 {
    static long S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());
        long result = 0L;
        long i = 1L;

        while (true) {
            result += i;
            if (result > S) {
                System.out.println(i-1);
                break;
            }
            i++;
        }

    }
}
