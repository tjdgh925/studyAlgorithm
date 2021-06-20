package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return this.index;
	}

	public int getDistance() {
		return this.distance;
	}
}

public class Dijkstra1 {

	public static final int INF = Integer.MAX_VALUE;

	public static int N, M, start;

	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static boolean[] visited = new boolean[100001];

	public static int[] d = new int[100001];

	public static int getShortest() {
		int MIN = INF;
		int index = 0;
		for (int i = 0; i <= N; i++) {
			if (d[i] < MIN && !visited[i]) {
				MIN = d[i];
				index = i;
			}
		}
		return index;
	}

	public static void dijkstra(int start) {
		d[start] = 0;
		visited[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
		}

		for (int i = 0; i < d.length; i++) {
			int now = getShortest();
			visited[now] = true;

			for (int j = 0; j < graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();

				if (cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);
        
        dijkstra(start);

        for (int i = 1; i <= N; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            else {
                System.out.println(d[i]);
            }
        }
    }
}