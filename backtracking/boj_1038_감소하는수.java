package backtracking;

import java.io.*;
import java.util.*;

public class boj_1038_감소하는수 {
    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N <= 10) {
            System.out.println(N);
        } else {
            for (int i = 0; i < 10; i++) {
                calculator((long) i);
            }
            Collections.sort(list);

            if (N >= list.size()) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(N));
            }
        }



    }

    private static void calculator(long num) {
        if (num > Long.parseLong("9876543210")) {
            return;
        }
        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                calculator((num*10) + (long)i);
            }
        }
    }
}

