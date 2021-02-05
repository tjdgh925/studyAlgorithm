package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2583_영역구하기 {
	static int M, N, K;
	static int[][] area;
	static PriorityQueue<Integer> result = new PriorityQueue<>();
	static int[] dx = { -1, 0 , 1, 0};
	static int[] dy = { 0, -1 , 0, 1};
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		int dfsCnt = 0;
		for (int i = 0; i < K; i++) {
			int x1, x2, y1, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			fillArea(x1,y1,x2,y2);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(area[i][j] != 1) {
					count = 0;
					empty(i, j);
					dfsCnt++;
					result.add(count);
				}
			}
		}
		System.out.println(dfsCnt);
		for (int i = 0; i < dfsCnt; i++) {
			System.out.print(result.poll() + " ");
		}

	}

	static void empty(int x, int y) {
		area[x][y] = 1;
		count ++;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > M-1)
				continue;
			if(area[nextX][nextY] != 1) {
				empty(nextX, nextY);
			}
			
		}
	}

	static void fillArea(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2-1; i++) {
			for (int j = y1; j <= y2-1; j++) {
				area[i][j] = 1;
			}
		}
	}
}
