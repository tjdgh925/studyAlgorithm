package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026_적록색약 {
	static int N;
	static char[][] paint;	
	static char[][] paintMutant;	
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int normalCount = 0, mutantCount = 0;
		paint = new char[N][N];
		paintMutant = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				paint[i][j] = str.charAt(j);
				paintMutant[i][j] = paint[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(paint[i][j] == 'R' || paint[i][j] == 'G') {
					normalSearch(i,j, paint[i][j]);
					normalCount++;
				}else if(paint[i][j] == 'B') {
					normalSearch(i,j,'B');
					normalCount++;
				}
				if(paintMutant[i][j] == 'R' || paintMutant[i][j] == 'G') {
					mutantSearch(i,j, paintMutant[i][j]);
					mutantCount++;
				}else if(paintMutant[i][j] == 'B') {
					mutantSearch(i,j,'B');
					mutantCount++;
				}
			}
		}
		System.out.println(normalCount + " " + mutantCount);
	}
	static void normalSearch(int x, int y, char c) {
		paint[x][y] = 'X';
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > N-1)
				continue;
			if(paint[nextX][nextY] == c) {
				normalSearch(nextX, nextY, c);
			}
		}
	}
	static void mutantSearch(int x, int y, char c) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
			}
		}
		paintMutant[x][y] = 'X';
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > N-1)
				continue;
			if(c == 'B') {
				if(paintMutant[nextX][nextY] == c) {
					mutantSearch(nextX, nextY, c);
				}				
			}else if(c == 'R' || c == 'G') {
				if(paintMutant[nextX][nextY] == 'R' || paintMutant[nextX][nextY] == 'G') {
					mutantSearch(nextX, nextY, c);
				}
			}
		}
	}
}
