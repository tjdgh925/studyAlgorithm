package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932_정수삼각형 {
	static int arr[][];
	static Integer dp[][];
	static int N;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new Integer[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		
		System.out.println(find(0,0));
	}
	static int find(int depth, int index) {
		if(depth == N-1) return dp[depth][index];
		if (dp[depth][index] == null) {
			dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + arr[depth][index];
		}
		return dp[depth][index];
		
		
	}
}
