package greedyAlgorithm;

import java.util.*;

public class boj11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int result = 0;
		Integer[] coinTypes = new Integer[N];
		for (int i = 0; i < N; i++) {
			coinTypes[i] = sc.nextInt();
		}
		Arrays.sort(coinTypes, Collections.reverseOrder());
		int i = 0;
		while (K != 0) {
			if (K / coinTypes[i] > 0) {
				result++;
				K -= coinTypes[i];
			} else {
				i++;
			}
		}
		System.out.println(result);
	}
}
