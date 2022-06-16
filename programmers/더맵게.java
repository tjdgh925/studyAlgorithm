package programmers;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    /**
     * scoville	            K	return
     * [1, 2, 3, 9, 10, 12]	7	2
     */
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            int c = a + (b * 2);
            pq.add(c);
        }
        return answer;
    }
}
