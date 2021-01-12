package greedyAlgorithm;

import java.util.*;

public class untilOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;

		while (n != 1) {
			if (n % k == 0) {
				n /= k;
				cnt++;
			} else{
				n -= 1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
