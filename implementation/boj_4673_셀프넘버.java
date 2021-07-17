package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_4673_셀프넘버 {
	static boolean check[];

	public static void main(String[] args) throws IOException {
		check = new boolean[101];

		for (int i = 1; i < 101; i++) {
			int n = selfNumber(i);

			if (n < 101) {
				check[n] = true;
			}
		}
		for (int i = 1; i < 101; i++) {
			if (!check[i])
				System.out.println(i);
		}
	}

	private static int selfNumber(int n) {
		int sum = n;
		while (n != 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		return sum;
	}
}
