package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node5 implements Comparable<Node5> {
	private int x;
	private int y;
	private int distance;

	public Node5(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node5 other) {
		// TODO Auto-generated method stub
		if (this.distance < other.distance)
			return -1;
		return 1;
	}

}

public class boj_4485_녹색옷입은애가젤다지 {
	static int N;
	public static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] dijkstra;
	static int[][] map;
	static int MAX = Integer.MAX_VALUE;
	static StringTokenizer st;

	public static void dijkstra() {
		PriorityQueue<Node5> pq = new PriorityQueue<Node5>();
		dijkstra[0][0] = map[0][0];
		pq.offer(new Node5(0, 0, map[0][0]));
		while(!pq.isEmpty()) {
			Node5 temp = pq.poll();
			
			for(int[] direction : directions) {
				int nextX = temp.getX()+direction[0];
				int nextY = temp.getY()+direction[1];
			
				if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > N-1) {
					continue;	
				}
				if(dijkstra[nextX][nextY] > dijkstra[temp.getX()][temp.getY()] + map[nextX][nextY]) {
					dijkstra[nextX][nextY] = dijkstra[temp.getX()][temp.getY()] + map[nextX][nextY]; 
					pq.offer(new Node5(nextX, nextY, dijkstra[nextX][nextY])); 
				}
			}
		}
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			count++;
			dijkstra = new int[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijkstra[i][j] = MAX;
				}
			}
			dijkstra();
			System.out.println("Problem " + count + ": " + dijkstra[N-1][N-1]);
		}
	}

}
