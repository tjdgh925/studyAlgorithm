package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3512_예산 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int MAX = Integer.parseInt(br.readLine());
		int start = 0;
		int mid = 0;
		int end = Integer.MAX_VALUE;
		while(start <= end) {
			mid = (start + end) / 2;
			long result = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] > mid)
					result += mid;
				else
					result += arr[i];
			}
			if(result < MAX) {
				end = mid - 1;
			}else {
				result = mid;
				start = mid +1;
			}
		}
		System.out.println(mid);
	}
}
