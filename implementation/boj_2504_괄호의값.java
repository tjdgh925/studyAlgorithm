package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_2504_괄호의값 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int sum = 1;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '(') {
                stack.push(cur);
                sum *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                sum *= 3;
            }
            else {
                if (cur == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        answer += sum;
                    }
                    stack.pop();
                    sum /= 2;
                }
                else if (cur == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        answer += sum;
                    }
                    stack.pop();
                    sum /= 3;
                }
            }
        }

        System.out.println(stack.isEmpty() ? answer : 0);
    }
}