package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2693_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                arr.add(Integer.parseInt(str[j]));
            }
            Collections.sort(arr);
            sb.append(arr.get(7)+"\n");
        }
        System.out.println(sb.toString());
    }
}
