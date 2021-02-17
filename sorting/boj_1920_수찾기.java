package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {
	static int N, M;
	static int arr1[], arr2[];
	static boolean binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == target) 
				return true;
			else if(arr[mid] > target) 
				end = mid -1;
			else 
				start = mid + 1;
		}
		return false;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		for (int i = 0; i < M; i++) {
			boolean flag = binarySearch(arr1, arr2[i], 0, N-1);
			if(flag)
				System.out.println('1');
			else
				System.out.println('0');
		}
	}
}
