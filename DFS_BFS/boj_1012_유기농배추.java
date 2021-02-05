package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012_유기농배추 {
	static int T;
	static int[][] field;
	static int M, N, K;
	static Queue<Integer> result = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	
	public static void caterpillar(int x, int y) {
		field[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			if(x+dx[i] > M-1 || x+dx[i] < 0 || y+dy[i] > N-1 || y+dy[i] < 0)
				continue;
			if(field[x+dx[i]][y+dy[i]] == 1) {
				caterpillar(x+dx[i], y+dy[i]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[M][N];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int posX = Integer.parseInt(st.nextToken());
				int posY = Integer.parseInt(st.nextToken());
				field[posX][posY] = 1;
			}	
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(field[j][k] == 1) {
						caterpillar(j,k);
						count++;
					}
				}
			}
			result.add(count);
		}
		for (int i = 0; i < T; i++) {
			System.out.println(result.poll());
		}
	}

}
