package greedyAlgorithm;
//문자수
import java.util.*;

public class boj11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int[] result = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(i == 0) 
				result[i] = arr[i];
			else
				result[i] = result[i-1] + arr[i];
			sum += result[i];
		}
		System.out.println(sum);
	}
}
