package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_10870_피보나치수5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        for (int i = 2; i <= n; i++) {
            arr.add(arr.get(i - 1) + arr.get(i - 2));
        }
        System.out.println(arr.get(n));
    }
}
