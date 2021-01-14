package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1316_그룹단어체커 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		int result = 0;
		int[] alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		for (int i = 0; i < N; i++) {
			int flag = 0;
			String temp = arr[i];
			for (int j = 0; j < alphabet.length; j++) {
				alphabet[j] = 0;
			}
			for (int j = 0; j < temp.length(); j++) {
				if(j ==0) {
					alphabet[(temp.charAt(j)- 97)] = 1;
				}
				else if (j > 0){
					if((temp.charAt(j-1) != temp.charAt(j)) &&
						alphabet[(temp.charAt(j)- 97)] == 1) {
						flag = 1;
					}else
						alphabet[(temp.charAt(j)- 97)] = 1;
				}
				if(flag == 1) {
					break;
				}
			}
			if(flag == 0)
				result++;
		}
		System.out.println(result);
	}
}
