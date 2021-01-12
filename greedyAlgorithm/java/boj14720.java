package greedyAlgorithm;

import java.util.Scanner;

public class boj14720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] milk = new int[n];
		int match = 0;
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			milk[i] = sc.nextInt();
		}
		for (int i = 0; i < milk.length; i++) {
			if(milk[i] == match) {
				cnt++;
				match++;
			}
			if(match == 3) match = 0;
		}
		System.out.println(cnt);
	}
}
