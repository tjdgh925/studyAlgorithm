package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alphabet = new int[26];
		int max = 0, cnt = 0, num = 0;
		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i)-65]++;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				num = i;
				cnt=1;
			}else if(max == alphabet[i]) {
				cnt++;
			}
		}
		if(cnt == 1) {
			System.out.println((char) (num + 65));
		}else {
			System.out.println('?');
		}
	}
}
