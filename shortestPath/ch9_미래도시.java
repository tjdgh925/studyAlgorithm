package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch9_미래도시 {
	static int N, M, K, X;
	static int[][] map;
	static int MAX = (int) 1e9;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], MAX);
			for (int j = 0; j < N; j++) {
				if (i == j) map[i][j] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken()) - 1;
		K = Integer.parseInt(st.nextToken()) - 1;
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		System.out.println(map[0][K] + map[K][X]);
	}
}
