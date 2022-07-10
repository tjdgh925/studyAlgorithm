package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int cnt = 0;
        int sum = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int truck : truck_weights) {

            while (true) {
                if (que.isEmpty()) {
                    que.add(truck);
                    sum += truck;
                    cnt++;
                    break;
                } else if (que.size() == bridge_length) {
                    sum -= que.poll();
                } else {
                    if (sum + truck <= weight) {
                        que.add(truck);
                        sum += truck;
                        cnt++;
                        break;
                    } else {
                        que.add(0);
                        cnt++;
                    }
                }

            }
        }
        return cnt + bridge_length;
    }

    public static void main(String[] args) {
//        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
//        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }
}
