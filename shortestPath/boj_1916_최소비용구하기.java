package graph;

import java.io.*;
import java.util.*;

public class boj_1916_최소비용구하기 {

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) return -1;
            else return 1;
        }
    }

    static int N, M, start, dest;
    static List<List<Node>> graph = new ArrayList<>();
    static int dist[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);

        djikstra(start);
        System.out.println(dist[dest]);
    }

    private static void djikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int distance = node.distance;
            int index = node.index;

            if (dist[index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = dist[index] + graph.get(index).get(i).distance;
                if (cost < dist[graph.get(index).get(i).index]) {
                    dist[graph.get(index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }
}
