package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2661_좋은수열 {

    static int N;
    static int start = 1;
    static int end = 3;

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String s) {
        if (s.length() == N) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = start; i <=end; i++) {
            if(check(s+i)){
                backtracking(s+i);
            }
        }
    }

    private static boolean check(String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            String back = s.substring(s.length() - i, s.length());
            String front = s.substring(s.length() - i * 2, s.length() - i);
            if(back.equals(front))
                return false;
        }
        return true;
    }

}
