package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch8_바닥공사 {
	public static int dp[] = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
		}
		System.out.println(dp[N]);
	}
}
