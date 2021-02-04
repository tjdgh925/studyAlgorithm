package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch5_음료수얼려먹기 {
	public static int[][] iceTray;
	public static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int N, M;
	
	public static void dfs(int x, int y) {
		iceTray[x][y] = 1;

		for(int[] direction : directions) {
			int nextX = x + direction[0];
			int nextY = y + direction[1];
		
			if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > M - 1) {
				continue;
			}
			
			if (iceTray[nextX][nextY] != 1) {
				dfs(nextX, nextY);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		N = Integer.parseInt((st.nextToken()));
		M = Integer.parseInt((st.nextToken()));
		iceTray = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				iceTray[i][j] = str.charAt(j) -'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(iceTray[i][j] == 0) {
					dfs(i , j);
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}

}
