package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 소수만들기 {

    /**
     * nums	        result
     * [1,2,3,4]	1
     * [1,2,7,6,4]	4
     */

    static int[] arr; 
    public int solution(int[] nums) {
        int answer = 0;
        int sum = IntStream.of(nums).sum();
        prime(sum);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (arr[num] == 0) {
                        answer++;
                    }
                }
            }
        }


        return answer;
    }
    
    static void prime(int sum) {
        arr = new int[sum+1];
        arr[1] = 1;
        Arrays.fill(arr, 0);
        for (int i = 2; i <= sum; i++) {
            if (arr[i] == 0) {
                for (int j = i+i; j <= sum; j+=i) {
                    arr[j] = j;
                }
            }
        }
    }
    
}
