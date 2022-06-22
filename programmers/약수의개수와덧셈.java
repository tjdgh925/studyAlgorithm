package programmers;

public class 약수의개수와덧셈 {


    public static void main(String[] args) {
        System.out.println(solution(24, 27));
    }
    /**
     * left	right	result
     * 13	17	    43
     * 24	27	    52
     */

    static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int temp = count(i);
            if (temp % 2 == 0)
                answer+= i;
            else answer -= i;
        }
        return answer;
    }

    static int count(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = num; j >= 1; j--) {
                if (i * j == num) {
                    cnt++;
                    continue;
                }
            }
        }
        return cnt;
    }
}
