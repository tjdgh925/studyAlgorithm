package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1303_전쟁전투 {

    static int N, M;
    static int cnt = 0;
    static int W = 0, B = 0;
    static char[][] map;
    static boolean[][] visit;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    cnt = 0;
                    if (map[i][j] == 'W') {
                        dfs(i, j, 'W');
                        W += cnt * cnt;
                    }
                    if (map[i][j] == 'B') {
                        dfs(i, j, 'B');
                        B += cnt * cnt;
                    }
                }
            }
        }

        System.out.println(W + " " + B);
    }

    static void dfs(int x, int y, char c) {
        visit[x][y] = true;
        cnt++;
        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx > N - 1 || nx < 0 || ny > M - 1 || ny < 0 || visit[nx][ny])
                continue;

            if (map[nx][ny] == c)
                dfs(nx, ny, c);
        }
    }
}
