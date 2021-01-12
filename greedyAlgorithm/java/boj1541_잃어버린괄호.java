package greedyAlgorithm;

import java.util.*;

public class boj1541_잃어버린괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int result = 0;
		String[] sub = sc.next().split("-");
		
		String[] tmp = sub[0].split("\\+");
		for (String s : tmp) {
			sum += Integer.parseInt(s);
		}
		for (int i = 1; i < sub.length; i++) {
			String[] temp = sub[i].split("\\+");
			for (String s : temp) {
				result += Integer.parseInt(s);			
			}
		}
		System.out.println(sum-result);
	}
}
