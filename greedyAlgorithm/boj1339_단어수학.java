package greedyAlgorithm;

import java.util.*;

public class boj1339_단어수학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		int[] alphabet = new int[26];
		int result = 0;
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}
		for (int i = 0; i < N; i++) {
			String tmp = str[i];
			for (int j = 0; j < tmp.length(); j++) {
				alphabet[(tmp.charAt(j)- 65)] += (int)Math.pow(10, tmp.length()-j-1);
			}
		}
		Arrays.sort(alphabet);
		for (int i = 25, k = 9; i > 0; i--, k--) {
			if(alphabet[i] == 0) break; 
				result += alphabet[i] * k;
		}
		System.out.println(result);
	}
	
}
