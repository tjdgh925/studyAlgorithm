package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_5430_AC {
//배열 자체를 reverse가 아니라
//deque 자료구조를 사용해야한다.
	public static int T, N;
	public static Deque<String> deque;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			char[] command = p.toCharArray();

			N = Integer.parseInt(br.readLine());
			
			String array = br.readLine();
			array = array.substring(1, array.length() - 1);
			deque = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(array, ",");
			while (st.hasMoreTokens()) {
				deque.add(st.nextToken());
			}
			flag = true;
			boolean error = false;
			for (int j = 0; j < command.length; j++) {
				if (command[j] == 'R') {
					flag = !flag;
				} else {
					if (deque.isEmpty()) {
						error = true;
						break;
					}
					if (flag)
						deque.pollFirst();
					else
						deque.pollLast();
				}
			}
			if (!error) {
				System.out.print("[");
				if (flag) {
					while (!deque.isEmpty()) {
						if (deque.size() == 1)
							System.out.print(deque.pollFirst());
						else
							System.out.print(deque.pollFirst() + ",");
					}
				} else {
					while (!deque.isEmpty()) {
						if (deque.size() == 1)
							System.out.print(deque.pollLast());
						else
							System.out.print(deque.pollLast() + ",");
					}
				}
				System.out.println("]");
			}
			else
				System.out.println("error");
		}
	}
}