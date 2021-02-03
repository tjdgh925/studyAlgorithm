package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> money = new Stack<>();
		int result = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0 && !money.isEmpty()) 
				money.pop();
			else
				money.push(input);
		}
		while(!money.isEmpty()) {
			result += money.pop();
		}
		System.out.println(result);
	}
}
