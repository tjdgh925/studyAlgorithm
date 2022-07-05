package programmers;

public class _3진법뒤집기 {

    public int solution(int n) {
        return conversion(n);
    }

    static int conversion(int num) {
        StringBuilder sb = new StringBuilder();
        int cur = num;

        while (cur > 0) {
            if (cur % 3 < 10) {
                sb.append(cur % 3);
            } else{
                sb.append((char) (cur % 3 - 10 + 'A'));
            }
            cur /= 3;
        }
        long num3 = Long.parseLong(sb.toString());
        char[] nums = String.valueOf(num3).toCharArray();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 'A') {
                answer = answer * 3 + (nums[i] - 'A' + 10);
            } else {
                answer = answer * 3 + (nums[i] - '0');
            }
        }

        return answer;
    }
}
