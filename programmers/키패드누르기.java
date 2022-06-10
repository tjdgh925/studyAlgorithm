package programmers;

public class 키패드누르기 {
    static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int left = 10;
        int right = 12;


        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            } else {
                int pathLeft = findLength(left, number);
                int pathRight = findLength(right, number);

                if (pathLeft == pathRight) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = number;
                    } else {
                        answer.append("R");
                        right = number;
                    }
                } else if (pathLeft < pathRight) {
                    answer.append("L");
                    left = number;
                } else {
                    answer.append("R");
                    right = number;
                }
            }
        }

        return answer.toString();
    }

    static int findLength(int idx, int number) {
        idx = (idx == 0) ? 11 : idx;
        number = (number == 0) ? 11 : number;

        int idxY = (idx - 1) / 3;
        int idxX = (idx - 1) % 3;
        int numY = number / 3;
        int numX = 1;

        return Math.abs(idxY-numY) + Math.abs(idxX-numX);
    }

}
