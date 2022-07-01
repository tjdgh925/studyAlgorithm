package programmers;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length() - 1;
        char[] arr = name.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            answer += Math.min('Z' - arr[i] + 1, arr[i] - 'A');
            index = i + 1;

            while (index < arr.length && arr[index] == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + arr.length - index);
            move = Math.min(move, (arr.length - index) * 2 + i);
        }
        return answer + move;
    }
}