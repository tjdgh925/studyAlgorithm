package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2665_미로만들기 {
	static int N;
	static int map[][], visit[][];
	static int[] dx = { -1, 0 , 1, 0};
	static int[] dy = { 0, -1 , 0, 1};
	static int MAX = Integer.MAX_VALUE;
	
	static class Position{
		int x;
		int y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		
		q.add(new Position(x,y));
		visit[0][0] = 0;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
				
				if(visit[nx][ny] <= visit[p.x][p.y]) continue;
				
				if(map[nx][ny] == 1) {
					q.add(new Position(nx,ny));
					visit[nx][ny] = visit[p.x][p.y];
				} else {
					q.add(new Position(nx,ny));
					visit[nx][ny] = visit[p.x][p.y] + 1;
				}
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) -'0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
		System.out.println(visit[N-1][N-1]);
	}
}
