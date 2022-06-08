package DFS_BFS;

import java.io.*;
import java.util.*;

public class boj_2667_단지번호붙이기 {
    static int N;
    static int[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int cnt = 0, num = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    num = 0;
                    dfs(i, j);
                    pq.add(num);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static void dfs(int y, int x) {
        map[y][x] = 0;
        num++;

        for (int[] direction : directions) {
            int nY = y - direction[0];
            int nX = x - direction[1];

            if (nX < 0 || nX > N - 1 || nY < 0 || nY > N - 1)
                continue;

            if (map[nY][nX] == 1)
                dfs(nY, nX);
        }
    }


}
