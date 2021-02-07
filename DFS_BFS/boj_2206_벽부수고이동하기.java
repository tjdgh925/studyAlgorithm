package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class boj_2206_벽부수고이동하기 {
	static class Place{
		int x;
		int y;
		int breakWall;
		int count;
		
		public Place(int y, int x, int cnt, int bw) {
			this.x = x;
			this.y = y;
			this.breakWall = bw;
			this.count = cnt;
		}
	}
	static int N, M, result;
	static int[][] maze, visit;
	static int[] dx = { -1, 0 , 1, 0};
	static int[] dy = { 0, -1 , 0, 1};
	static int count = 0;
	
	public static void bfs(int x, int y) {
		Queue<Place> queue = new LinkedList<>();
		
		 queue.add(new Place(y, x, 1 , 0));
		 visit[y][x] = 0;
		 
		 while(!queue.isEmpty()) {
			 
			 Place curr = queue.poll();
			 
			 if(curr.x == M-1 && curr.y == N-1) {
				 result = curr.count;
				 break;
			 }
			 
			 for (int i = 0; i < 4; i++) {
				int nextX = curr.x + dx[i];
				int nextY = curr.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX > M-1 || nextY > N-1)
					continue;
				
				if(visit[nextY][nextX] <= curr.breakWall) continue;
				
				if(maze[nextY][nextX] == 0) { //길일경우 
					visit[nextY][nextX] = curr.breakWall;
					queue.add(new Place(nextY, nextX, curr.count+1, curr.breakWall));
				}
				else {
					if(curr.breakWall == 0) {
						visit[nextY][nextX] = curr.breakWall + 1;
						queue.add(new Place(nextY, nextX, curr.count+1, curr.breakWall+1));
					}
				}
			 }
		 }
		
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		result = Integer.MAX_VALUE;
		bfs(0,0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		
	}
}
