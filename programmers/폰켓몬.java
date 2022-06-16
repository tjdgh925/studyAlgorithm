package programmers;

import java.util.HashSet;

public class 폰켓몬 {

    /**
     * nums	            result
     * [3,1,2,3]	    2
     * [3,3,3,2,2,4]	3
     * [3,3,3,2,2,2]	2
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        answer = nums.length / 2 >= set.size() ? nums.length / 2 : set.size();
        return answer;
    }
}
