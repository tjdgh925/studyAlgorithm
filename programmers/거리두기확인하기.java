package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    //두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.

    /**
     * places	                                        result
     * [                                                [1, 0, 1, 1, 1]
     * ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
     * ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
     * ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
     * ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
     * ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]
     * ]
     *
     */
    public static void main(String[] args) {
        int[] solution = solution(new String[][]{
                {"PXOOO", "XPOOO", "OOOOO", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }


    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char waiting[][] = new char[5][5];

    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for (int i  = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    waiting[j][k] = places[i][j].charAt(k);
                }
            }

            for (int j = 0; j < waiting.length; j++) {
                for (int k = 0; k < waiting[j].length; k++) {
                    if (waiting[j][k] == 'P') {

                        if (!check(j, k)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }


    static boolean check(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.poll()[1];
            for (int[] direction : directions) {

                int nx = cx - direction[0];
                int ny = cy - direction[1];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                if (visit[nx][ny] || manhattan > 2) {
                    continue;
                }

                visit[nx][ny] = true;

               if (waiting[nx][ny] == 'X'){
                   continue;
               } else if (waiting[nx][ny] == 'P') {
                   return false;
               } else q.offer(new int[]{nx, ny});

            }
        }
        return true;
    }
}
