package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ch6_두배열의원소교체 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer arr1[] = new Integer[N];
		Integer arr2[] = new Integer[N];
		int result = 0;
		String str1 = br.readLine();
		String str2 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		StringTokenizer st2 = new StringTokenizer(str2);
		for (int i = 0; i < N; i++) {		
			arr1[i] = Integer.parseInt(st1.nextToken()); 
			arr2[i] = Integer.parseInt(st2.nextToken()); 
		}
		//책풀이 
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		for (int i = 0; i < K; i++) {
			if(arr1[i] < arr2[i]) {
				int temp = arr1[i];
				arr1[i] = arr2[i];
				arr2[i] = temp;
			}
			else break;
		}
		for (int i = 0; i < arr1.length; i++) {
			result += arr1[i];
		}
		
//		//내 풀이
//		for (int i = 0; i < K; i++) {
//			int MAX = 0;
//			int MIN = Integer.MAX_VALUE;
//			int pos1 = 0, pos2 = 0;
//			for (int j = 0; j < N; j++) {
//				if(arr1[j] < MIN) {
//					MIN = arr1[j];
//					pos1 = j;
//				}
//				if(arr2[j] > MAX) {
//					MAX = arr2[j];
//					pos2 = j;
//				}
//			}
//			arr1[pos1] = MAX;
//			arr2[pos2] = MIN;
//		}
//		for (int i = 0; i < arr1.length; i++) {
//			result += arr1[i];
//		}
		System.out.println(result);
	}
}
