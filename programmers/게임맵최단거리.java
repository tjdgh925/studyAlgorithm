package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static boolean visit[][];
    static int dist[][];
    static int X, Y;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        solution(
                new int[][]{
                        {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
                }
        );
    }

    static int solution(int[][] maps) {
        int answer = 0;

        X = maps.length;
        Y = maps[0].length;
        visit = new boolean[X][Y];
        dist = new int[X][Y];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        bfs(0, 0, maps);

        answer = dist[X - 1][Y - 1] == Integer.MAX_VALUE ? -1 : dist[X - 1][Y - 1];

        return answer;
    }

    static void bfs(int x, int y, int[][] maps) {
        Queue<Integer[]> q = new LinkedList<>();
        visit[x][y] = true;
        dist[x][y] = 1;
        q.add(new Integer[]{x, y});

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int cX = cur[0];
            int cY = cur[1];

            for (int[] direction : directions) {
                int nX = cX + direction[0];
                int nY = cY + direction[1];

                if (nX < 0 || nX > X - 1 || nY < 0 || nY > Y - 1 || visit[nX][nY]) {
                    continue;
                }

                if (maps[nX][nY] == 1) {
                    dist[nX][nY] = Math.min(dist[nX][nY], dist[cX][cY] + 1);
                    visit[nX][nY] = true;
                    q.add(new Integer[]{nX, nY});
                }
            }
        }
    }
}
