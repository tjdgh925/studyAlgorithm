package programmers;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            if (idx == numbers.length){
                answer += i;
                continue;
            }
            if (numbers[idx] == i) {
                idx++;
                continue;
            } else if (numbers[idx] > i) {
                answer+=i;
                continue;
            }
        }
        return answer;
    }
}
