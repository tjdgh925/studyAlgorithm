package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node4 implements Comparable<Node4> {
	int index;
	int distance;
	
	public Node4(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public int compareTo(Node4 other) {
		// TODO Auto-generated method stub
		if (this.distance < other.distance)
			return -1;
		return 1;
	}
}
public class boj_1753_최단경로 {

	static int MAX = Integer.MAX_VALUE;
	static int N, M, K;
	public static ArrayList<ArrayList<Node4>> graph = new ArrayList<ArrayList<Node4>>();
	public static int[] d = new int[100001];
	static StringTokenizer st;

	public static void dijkstra(int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Node4> pq = new PriorityQueue<Node4>();
		pq.offer(new Node4(start, 0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Node4 temp = pq.poll();
			int dist = temp.getDistance();
			int now = temp.getIndex();
			if(d[now] < dist) continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node4(graph.get(now).get(i).getIndex(), cost));
				}	
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node4>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node4(b,c));
		}
		
		Arrays.fill(d, MAX);
		
		dijkstra(K);
		
		for (int i = 1; i <= N; i++) {
			if(d[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(d[i]);			
		}
	}

}
