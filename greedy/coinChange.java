package greedyAlgorithm;

import java.util.Scanner;

public class coinChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("N을 입력하세요: ");
		int n = sc.nextInt();
		int cnt = 0;
		int[] coinTypes = { 500, 100, 50, 10 };

		for (int i = 0; i < coinTypes.length; i++) {
			int coin = coinTypes[i];
			cnt += n / coin;
			n %= coin;
		}
		System.out.println(cnt);
	}
}
