package programmers;

import java.util.*;

public class K번째수 {
    /**
     * array	                commands	                        return
     * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
     */

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution) {
            System.out.print(i);
        }
    }


    static int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int index = command[2] - 1;

            int[] sub = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sub);
            answer.add(sub[index]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
