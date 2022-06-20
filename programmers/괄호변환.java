package programmers;

import java.util.Stack;

public class 괄호변환 {


    /**
     * p	        result
     * "(()())()"	"(()())()"
     * ")("	        "()"
     * "()))((()"	"()(())()"
     */
    public static void main(String[] args) {
        System.out.println(solution(")("));
    }
    static String solution(String p) {

        if (p.isEmpty())
            return "";
        if(check(p))
            return p;

        StringBuilder temp = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int idx = 0;
        StringBuilder u = new StringBuilder();
        u.append(p.charAt(idx));
        stack.add(p.charAt(idx++));


        while (!stack.isEmpty()) {
            if (stack.peek() == p.charAt(idx)) {
                u.append(p.charAt(idx));
                stack.add(p.charAt(idx++));
            } else {
                stack.pop();
                u.append(p.charAt(idx++));
            }
        }

        String v = p.substring(idx, p.length());


        if (check(u.toString())) {
            temp.append(u);
            temp.append(solution(v));
        } else {
            temp.append("(");
            temp.append(solution(v));
            temp.append(")");
            temp.append(swap(u.substring(1, u.length() - 1)));
        }

        return temp.toString();
    }

    private static String swap(String sub) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == '(')
                s.append(')');
            else
                s.append('(');
        }
        return s.toString();
    }

    private static boolean check(String u) {
        Stack<Character> stack = new Stack();
        if (u.charAt(0) != '(') {
            return false;
        }
        stack.add(u.charAt(0));
        for (int i = 1; i <u.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(u.charAt(i));
                continue;
            }

            if (stack.peek() == '(' && u.charAt(i) == ')') {
                stack.pop();
            } else
                stack.add(u.charAt(i));
        }
        return stack.isEmpty() ? true : false;
    }
}
