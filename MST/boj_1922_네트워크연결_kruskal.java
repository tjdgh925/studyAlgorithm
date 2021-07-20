package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge3 implements Comparable<Edge3> {
	private int distance;
	private int nodeA;
	private int nodeB;

	public Edge3(int distance, int nodeA, int nodeB) {
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
	public int compareTo(Edge3 other) {
		// TODO Auto-generated method stub
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class boj_1922_네트워크연결_kruskal {
	public static int v, e;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge3> Edge3s = new ArrayList<>();
	public static int result = 0;

	public static int findParent(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = findParent(parent[x]);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= v;i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Edge3s.add(new Edge3(cost, a, b));
		}
		
		Collections.sort(Edge3s);
		
		for (int i = 0; i < Edge3s.size(); i++) {
			int cost = Edge3s.get(i).getDistance();
			int a = Edge3s.get(i).getNodeA();
			int b = Edge3s.get(i).getNodeB();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
}
