package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463_1로만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 3 == 0) {
				d[i] = Math.min(d[i], d[i / 3] + 1);
			}
			if (i % 2 == 0) {
				d[i] = Math.min(d[i], d[i / 2] + 1);
			}
		}
		System.out.println(d[N]);
	}
}