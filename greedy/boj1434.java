package greedyAlgorithm;

import java.util.Scanner;

public class boj1434 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		
		int cnt = 1;

		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (c == 'S') {
				cnt++;
			} else {
				cnt++;
				i++;
			}
		}
		if (n >= cnt) System.out.println(cnt);
        else System.out.println(n);
	}
}
