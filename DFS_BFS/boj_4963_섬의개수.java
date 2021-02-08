package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4963_섬의개수 {
	static int dx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int dy[] = {1, 1, 1, 0, -1, -1, -1, 0};
	static int N , M;
	static int map[][];
	static Queue<Integer> result = new LinkedList<>();
	static void dfs(int x, int y) {
		map[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx > M-1 || ny > N-1) continue;
			
			if(map[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;
		while(true) {
			ch++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
//			System.out.println(N + " " + M);
			if(N == 0 && M ==0) break;
			int count = 0;
			map = new int[M][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						dfs(i,j);
						count++;
					}
				}
			}
			result.add(count);
		}
		while(!result.isEmpty()) {
			System.out.println(result.poll());
		}
	}
}
