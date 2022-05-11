package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int lcm = a*b;

        int result = gcd(a, b);
        lcm /= result;

        System.out.println(result);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
