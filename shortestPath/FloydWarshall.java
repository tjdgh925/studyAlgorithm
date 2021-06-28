package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshall {
	static int N, M;
	static int MAX = (int) 1e9;
	public static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], MAX);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					graph[i][j] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			int a, b, c;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) -1;
			b = Integer.parseInt(st.nextToken()) -1;
			c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
