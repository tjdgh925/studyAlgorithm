package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 최소직사각형 {

    public int solution(int[][] sizes) {
        PriorityQueue<Integer> big = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] size : sizes) {
            int a = size[0];
            int b = size[1];
            if (a > b) {
                big.add(a);
                small.add(b);
            } else {
                big.add(b);
                small.add(a);
            }
        }

        return big.poll() * small.poll();
    }

}
