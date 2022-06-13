package programmers;

public class 내적 {

    /**
     * 입출력
     * a	        b	            result
     * [1,2,3,4]	[-3,-1,0,2]	    3
     * [-1,0,1]	    [1,0,-1]	    -2
     */

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
