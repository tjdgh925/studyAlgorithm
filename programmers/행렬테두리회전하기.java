package programmers;

public class 행렬테두리회전하기 {

    /**
     * rows	columns	    queries	                                    result
     * 6	6	        [[2,2,5,4],[3,3,6,6],[5,1,6,3]]	            [8, 10, 25]
     * 3	3	        [[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
     * 100	97	        [[1,1,100,97]]	                            [1]
     */

    public static void main(String[] args) {
        int[] solution = solution(100, 97, new int[][]{{1, 1, 100, 97}});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    static int[][] map;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int[] answer = new int[queries.length];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        return answer;
    }

    private static int rotate(int x1, int y1, int x2, int y2) {
        int MIN = Integer.MAX_VALUE;
        int d = 0;
        int cy = y1;
        int cx = x1;
        int value = map[cx][cy];
        while (d < 4) {
            int ny = cy + directions[d][1];
            int nx = cx + directions[d][0];

            if (ny < y1 || ny > y2 || nx < x1 || nx > x2) {
                d++;
                continue;
            }
            int temp = map[nx][ny];
            map[nx][ny] = value;
            value = temp;
            MIN = Math.min(MIN, map[cx][cy]);
            cy = ny;
            cx = nx;

        }
        return MIN;
    }
}
