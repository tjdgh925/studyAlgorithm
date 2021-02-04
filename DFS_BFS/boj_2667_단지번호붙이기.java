package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_2667_단지번호붙이기 {
	public static int map[][];
	public static int N, dfsCnt = 0, count;
	public static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void bfs(int x, int y) {
		
	}
	public static void dfs(int x, int y) {
		map[x][y] = 0;
		count++;
		
		for(int[] direction : directions) {
			int nextX = x+direction[0];
			int nextY = y+direction[1];
		
			if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > N-1) {
				continue;	
			}
			if(map[nextX][nextY] != 0) {
				dfs(nextX,nextY);
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						count = 0;
						dfs(i , j);
						dfsCnt++;
						pq.add(count);
					}
			}
		}
		System.out.println(dfsCnt);
		for (int i = 0; i < dfsCnt; i++) {
			System.out.println(pq.poll());
		}
		
	}
}
