package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate{
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
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

public class ch5_미로탈출 {
	public static int[][] maze;
	public static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int N, M;
	public static void bfs(int x, int y) {
		Queue<Coordinate> queue = new LinkedList<>();
		
		queue.offer(new Coordinate(x, y));
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().getX();
			int currY = queue.poll().getY();
			
			for(int[] direction : directions) {
				int nextX = currX + direction[0];
				int nextY = currY + direction[1];
				
				if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > M - 1) {
					continue;
				}
				
				if (maze[nextX][nextY] == 1) {
					queue.offer(new Coordinate(nextX, nextY));
					maze[nextX][nextY] = maze[currX][currY]+1;
					
					if(nextX == N-1 && nextY == M-1) {
						return;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) -'0';
			}
		}
		bfs(0,0);
		System.out.println(maze[N-1][M-1]);
		
	}
}
