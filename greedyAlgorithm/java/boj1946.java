package greedyAlgorithm;

import java.io.IOException;
import java.util.*;

public class boj1946 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int count = 0;
			int N = sc.nextInt();
			int[] Grade1 = new int[100001];

			for (int i = 1; i <= N; i++) {
				Grade1[sc.nextInt()] = sc.nextInt();

			}

			int first = Grade1[1];
			for (int i = 1; i <= N; i++) {
				if (Grade1[i] <= first) {
					first = Grade1[i];
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
