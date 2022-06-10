package programmers;

public class 카카오프렌즈컬러링북 {

    public static void main(String[] args) {
        int picture[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6, 4, picture);

    }

    static int cnt;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean visited[][];

    static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (picture[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, m, n, picture);
                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    static void dfs(int y, int x, int m, int n, int[][] picture) {
        visited[y][x] = true;
        cnt++;

        for (int[] direction : directions) {
            int ny = y - direction[0];
            int nx = x - direction[1];

            if (ny < 0 || nx < 0 || ny > m - 1 || nx > n - 1) {
                continue;
            }
            if (picture[ny][nx] == picture[y][x] && !visited[ny][nx]) {
                dfs(ny, nx, m, n, picture);
            }
        }
    }
}
