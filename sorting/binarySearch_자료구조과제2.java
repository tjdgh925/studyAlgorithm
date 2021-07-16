package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch_자료구조과제2 {
//	public static boolean check(int x) {
//
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//총 참가자의 
		int N = Integer.parseInt(st.nextToken());
		//버스 총 개
		int M = Integer.parseInt(st.nextToken());
		//버스 정원
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		//탑승한 시간 배열
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//우선 정렬
		Arrays.sort(arr);
		//1 1 3 4 10 14

		int start = -1;
		int end = 1000000000;
		int result = 0;
		
		//이분탐색을 이용해서 조건을 통과할 경우 
		//최대값을 (중간값 - 1)로 설정하고,
		//통과하지 못할 경우에는
		//최소값을 (중간값 + 1)로 설정하면서, 
		//최대값과 최소값이 같아지는 값을 구한다.

		//처음 조건. 우선 설정한 최대 시간보다 길어지면 다음 버스 부른다.
		//두번째 조건. 정원이 넘을 경우 다음 버스 부른다.
		//버스에 해서 다 탔다. 
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int capacity = 1;
			int timesCount = arr[0];
			int bus = 1;

			for (int j = 1; j < N-1; j++) {
				timesCount = arr[capacity] - timesCount;
				if(timesCount > mid) {
					bus++;
					capacity = 1;
					timesCount = arr[j];
				}else {
					capacity++;
				}
				
				if(capacity == C) {
					bus++;
					timesCount = arr[j+1];
				}
			}
			if(bus <= mid) {
				end = mid-1;
			} else {
				start = mid+1;
			}
			
		}
		System.out.println(start);
	}

}
