package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1238_파티 {


    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance < o.getDistance())
                return -1;
            else
                return 1;
        }
    }

    static int N, M, X;
    static List<List<Node>> graph = new ArrayList<>();
    static int dist[][] = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        for (int i = 1; i <= N; i++) {
                djikstra(i);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
                result = Math.max(result, dist[i][X] + dist[X][i]);
        }

        System.out.println(result);

    }

    private static void djikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue();

        pq.offer(new Node(start, 0));

        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int distance = node.getDistance();
            int index = node.getIndex();

            if (dist[start][index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = dist[start][index] + graph.get(index).get(i).getDistance();
                if (cost < dist[start][graph.get(index).get(i).getIndex()]) {
                    dist[start][graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }

        }

    }
}

