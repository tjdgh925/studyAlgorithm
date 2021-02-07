package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Coordinates{
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

public class boj_2178_미로탐색 {
	static int N, M;
	static int[][] maze;
	static int[] dx = { -1, 0 , 1, 0};
	static int[] dy = { 0, -1 , 0, 1};
	static int count = 0;
	
	public static void bfs(int x, int y) {
		Queue<Coordinates> queue = new LinkedList<>();
		
		 queue.offer(new Coordinates(x, y));
		 
		 while(!queue.isEmpty()) {
			 int currX = queue.peek().getX();
			 int currY = queue.poll().getY();
			 
			 for (int i = 0; i < 4; i++) {
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > M-1)
					continue;
				if (maze[nextX][nextY] == 1) {
					queue.offer(new Coordinates(nextX, nextY));
					maze[nextX][nextY] = maze[currX][currY]+1;
					
					if(nextX == N-1 && nextY == M-1) {
						return;
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
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(maze[N-1][M-1]);
		
	}
}
