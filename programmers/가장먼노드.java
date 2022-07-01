package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    static int solution(int n, int[][] edge) {
        int answer = 0;
        int min = 0;

        List<List<Integer>> graph = new ArrayList<>();
        boolean visit[] = new boolean[n + 1];
        int distance[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }
        for (int[] node : edge) {
            int a = node[0];
            int b = node[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> que = new LinkedList<>();
        visit[1] = true;
        for (int i = 0; i < graph.get(1).size(); i++) {
            int node = graph.get(1).get(i);
            visit[node] = true;
            distance[node] = 1;
            que.offer(graph.get(1).get(i));
        }

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 0; i < graph.get(temp).size(); i++) {
                int node = graph.get(temp).get(i);
                if (visit[node])
                    continue;
                visit[node] = true;
                distance[node] = distance[temp] + 1;
                min = Math.max(min, distance[node]);
                que.offer(graph.get(temp).get(i));
            }
        }

        for (int i = 0; i <= n; i++) {
            if (distance[i] == min)
                answer++;
        }


        return answer;
    }
}

