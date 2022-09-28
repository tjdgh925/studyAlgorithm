package programmers;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        int[] solution = solution("00000");
        System.out.println(solution[0] +" " +  solution[1]);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zero = 0;

        while (!s.equals("1")) {
            System.out.println(s);
            cnt++;
            String noZero = s.replaceAll("0", "");
            int length = noZero.length();
            zero += s.length() - length;
            s = Integer.toBinaryString(length);
        }

        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}
