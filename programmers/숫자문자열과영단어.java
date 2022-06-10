package programmers;

import java.util.HashMap;
import java.util.List;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    static int solution(String s) {
        String result = "";
        List<String> numberList = List.of(new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"});

        int answer = 0;
        int start = 0;
        int end = 1;

        while (true) {
            if (start > s.length() || end > s.length()) {
                break;
            }
            char c = s.charAt(start);
            if (c >= '0' && c <= '9') {
                result+=c;
                start = end;
                end = end + 1;
            }
            else {
                String sub = s.substring(start, end);
                if (numberList.contains(sub)) {
                   result+=numberList.indexOf(sub);
                    start = end;
                    end = end + 1;
                }else {
                    end++;
                }
            }
        }

        answer = Integer.parseInt(result);
        return answer;
    }
}
