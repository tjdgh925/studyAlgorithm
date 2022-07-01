package programmers;

import java.util.*;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long start = 0;
        long end = n * (long) times[times.length - 1];

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }

        }
        return answer;
    }
}
