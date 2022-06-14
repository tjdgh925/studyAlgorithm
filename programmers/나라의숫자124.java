package programmers;

public class 나라의숫자124 {

    public static void main(String[] args) {
        System.out.println(solution(18));
    }

    public static String solution(int n) {
        StringBuffer answer = new StringBuffer();
        while (n != 0) {
            switch (n % 3) {
                case 1:
                    answer.append(1);
                    break;
                case 2:
                    answer.append(2);
                    break;
                case 0:
                    answer.append(4);
                    n--;
                    break;
            }
            n /= 3;
        }
        answer.reverse();
        return answer.toString();
    }
}
