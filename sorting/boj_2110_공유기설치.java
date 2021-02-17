package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_공유기설치 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int result = 0;
		Arrays.sort(arr);
		int start = 1;
		int end = arr[N-1] - arr[0];
		while(start <= end) {
			int mid = (start + end) / 2;
			int prevHouse = arr[0];
			int count = 1;
			for (int i = 0; i < N; i++) {
				int distance = arr[i] - prevHouse;
				if(distance >= mid) {
					count++;
					prevHouse = arr[i];
				}
			}
			if(count >= M) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}
