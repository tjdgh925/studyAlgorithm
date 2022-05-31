package graph;

import java.io.*;
import java.util.*;

public class boj_1197_최소스패닝트리 {
    static class Node implements Comparable<Node> {

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
            if(this.weight < o.weight) return -1;
            else return 1;
        }
    }

    static int V, E;
    static int[] parent;
    static int result = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }

        kruskal();

        System.out.println(result);
    }

    private static void kruskal() {

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int start = node.getFrom();
            int end = node.getTo();
            int cost = node.getWeight();

            if (findParent(start) != findParent(end)) {
                union(start, end);
                result += cost;
            }
        }
    }

    private static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB)
            parent[parentA] = parentB;
        else
            parent[parentB] = parentA;
    }

    private static int findParent(int idx) {
        if (parent[idx] == idx) {
            return idx;
        } else
            return findParent((parent[idx]));
    }
}
