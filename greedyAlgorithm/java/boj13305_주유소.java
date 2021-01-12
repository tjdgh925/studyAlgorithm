package greedyAlgorithm;

import java.util.*;

public class boj13305_주유소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] distance = new long[N-1];
		long[] cost = new long[N];
		
		for (int i = 0; i < N-1; i++) {
			distance[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextInt();
		}
		
		long totalCost = cost[0] * distance[0];
		
		int i = 0;
		int j = i+1;
		while(j < N - 1) {
			if(cost[i] < cost[j]) {
				totalCost += cost[i] * distance[j];
			}
			else {
				totalCost += cost[j] * distance[j];
				i=j;
			}
			j++;
		}
		System.out.println(totalCost);
	}
}
