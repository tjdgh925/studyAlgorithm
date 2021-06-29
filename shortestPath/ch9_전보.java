package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class city implements Comparable<city> {
	private int destin;
	private int distance;

	public city(int destin, int distance) {
		this.destin = destin;
		this.distance = distance;
	}

	public int getDestin() {
		return destin;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(city other) {
		// TODO Auto-generated method stub
		if (this.distance < other.distance)
			return -1;
		return 1;
	}
}

public class ch9_전보 {
	static ArrayList<ArrayList<city>> map = new ArrayList<ArrayList<city>>();
	static StringTokenizer st;
	static int N, M, C;
	static int d[];
	static int count = 0, MAX = 0;

	public static void dijkstra(int start) {
		PriorityQueue<city> pq = new PriorityQueue<city>();
		pq.offer(new city(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			city temp = pq.poll();
			int now = temp.getDestin();
			int distance = temp.getDistance();
			if (d[now] < distance)
				continue;
			for (int i = 0; i < map.get(now).size(); i++) {
				int cost = d[now] + map.get(now).get(i).getDistance();
				if (cost < d[map.get(now).get(i).getDestin()]) {
					d[map.get(now).get(i).getDestin()] = cost;
					pq.offer(new city(map.get(now).get(i).getDestin(), cost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken())-1;

		d = new int[N];
		for (int i = 0; i < N; i++) {
			map.add(new ArrayList<city>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			map.get(a).add(new city(b, c));
		}
		Arrays.fill(d, Integer.MAX_VALUE);
		dijkstra(C);

		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
			if (d[i] == Integer.MAX_VALUE)
				continue;
			else {
				count++;
				MAX = Math.max(MAX, d[i]);
			}
		}

		System.out.println(count-1 + " " + MAX);
	}
}
