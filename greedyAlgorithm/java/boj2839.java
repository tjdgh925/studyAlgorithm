package greedyAlgorithm;

import java.util.Scanner;

public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		while (true) {
			if (n % 3 == 0 && n % 5 == 0) {
				n -= 5;
			} else if (n % 5 == 0) {
				n -= 5;
			} else if (n % 3 == 0) {
				n -= 3;
			} else {
				n -= 5;
			}
			result++;

			if (n == 0) {
				System.out.println(result);
				return;
			}
			if (n < 0) {
				System.out.println(-1);
				return;
			}
		}
	}
}
