package graph;

import java.io.*;
import java.util.*;

public class boj_1647_도시분할계획 {

    static class Node implements Comparable<Node>{
        private int from;
        private int to;
        private int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight < o.weight)
                return -1;
            else
                return 1;
        }
    }

    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int result = 0;
    static int last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(f, t, w));
        }

        kruskal();

        System.out.println(result-last);
    }

    private static void kruskal() {

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int start = node.getFrom();
            int end = node.getTo();
            int cost = node.getWeight();

            if (find(start) != find(end)) {
                last = cost;
                result += cost;
                union(start, end);
            }
        }
    }

    private static void union(int start, int end) {
        int parentA = find(start);
        int parentB = find(end);

        if(parentA < parentB)  parent[parentA] = parentB;
        else parent[parentB] = parentA;
    }

    private static int find(int idx) {
        if (parent[idx] == idx)
            return idx;
        else
            return find(parent[idx]);
    }

}
