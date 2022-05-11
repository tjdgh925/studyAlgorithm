package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_2309_일곱난장이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if(i==j)
                    continue;
                int sum = arr.stream().mapToInt(Integer::intValue).sum();
                int first = arr.get(i);
                int second = arr.get(j);
                int check = sum - (first + second);
                if (check == 100){
                    arr.remove((Integer)first);
                    arr.remove((Integer)second);
                    break;
                }
            }
        }

        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
