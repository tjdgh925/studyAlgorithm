package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2581_소수 {
    public static boolean prime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;

        prime = new boolean[end + 1];
        get_prime();

        for (int i = start; i <= end; i++) {
            if (!prime[i]) {
                sum += i;
                if (min == Integer.MAX_VALUE)
                    min = i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}