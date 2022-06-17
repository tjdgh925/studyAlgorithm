package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 짝지어제거하기 {
    /**
     * s	    result
     * baabaa	1
     * cdcd	    0
     */


    public static void main(String[] args) {
        solution(new String("baabaa"));
    }


    static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }


        return stack.size() == 0 ? 1 : 0;
    }
}


