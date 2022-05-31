package KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16916_부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        KMP(S, P);
        System.out.println(0);
    }

    static int[] makeTables(String str) {
        int n = str.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i < n; i++) {

            while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = table[idx - 1];
            }

            if(str.charAt(i) == str.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

    static void KMP(String parent, String pattern) {
        int[] table = makeTables(pattern);

        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0;

        for (int i = 0; i < n1; i++) {
            while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (parent.charAt(i) == pattern.charAt(idx)) {
                if (idx == n2 - 1) {
                    System.out.println(1);
                    System.exit(0);
                } else {
                    idx += 1;
                }
            }
        }
    }
}

