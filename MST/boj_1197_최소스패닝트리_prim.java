package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge1 implements Comparable<Edge1> {
	private int distance;
	private int nodeA;
	private int nodeB;

	public Edge1(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge1 other) {
		// TODO Auto-generated method stub
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class boj_1197_최소스패닝트리_prim {
	public static int v, e;
	public static boolean[] visit;
	public static ArrayList<Edge1>[] edges;
	public static int result = 0;

		public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[v+1];
		visit = new boolean[v+1];
		
		for (int i = 0; i <= v;i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[a].add(new Edge1(cost, a, b));
			edges[b].add(new Edge1(cost, b, a));
		}
		int a =1;
		System.out.println(prim(a,visit,edges));
	}

		private static int prim(int s, boolean[] visit, ArrayList<Edge1>[] edges) {
			PriorityQueue<Edge1> pq = new PriorityQueue<>();
	        Queue<Integer> que = new LinkedList<>();
	        int answer = 0;
	 
	        que.add(s);
	 
	        while (!que.isEmpty()) {
	            int cur = que.poll();
	            visit[cur] = true;
	 
	            for (Edge1 edge : edges[cur]) {
	                if(!visit[edge.getNodeB()])
	                    pq.add(edge);	
	            }
	 
	            while (!pq.isEmpty()) {
	                Edge1 edge=pq.poll();
	                if (!visit[edge.getNodeB()]) {
	                    que.add(edge.getNodeB());
	                    visit[edge.getNodeB()] = true;
	                    answer += edge.getDistance();
	                    break;
	                }
	            }
	 
	        }
	        return answer;
	    }
}
