package programmers;


import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {

    static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j)
                    continue;
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
