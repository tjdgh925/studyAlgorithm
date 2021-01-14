package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1110_더하기사이클 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int temp = N;
		while(true) {
			if(temp == N && cnt != 0)
				break;
			else {
				temp = (temp%10) * 10 + ((temp/10 + temp%10)%10);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
