package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Node3 implements Comparable<Node3>{
	private int index;
	private int distance;
	public Node3(int index, int distance) {
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
	public int compareTo(Node3 other) {
		if(this.distance < other.distance)
			return -1;
		return 1;
	}
}

public class boj_1916_최소비용구하기 {
	static int N, M, start, dest;
	public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();
	public static int[] d = new int[100001];
	
	public static void djikstra(int start) {
		PriorityQueue<Node3> pq = new PriorityQueue<>();
		pq.offer(new Node3(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) { 
			Node3 node = pq.poll();
			int dist = node.getDistance(); 
			int now = node.getIndex(); 
			if (d[now] < dist)
				continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node3>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node3(b,c));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		djikstra(start);
		
		System.out.println(d[dest]);
	}

}
