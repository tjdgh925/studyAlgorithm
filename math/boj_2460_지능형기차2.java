package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2460_지능형기차2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int OUT = Integer.parseInt(st.nextToken());
            int IN = Integer.parseInt(st.nextToken());
            sum -= OUT;
            sum += IN;
            if (sum > MAX) {
                MAX = sum;
            }
        }
        System.out.println(MAX);
    }
}
