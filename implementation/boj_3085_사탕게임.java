package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_3085_사탕게임 {
    static int N;
    static int result = Integer.MIN_VALUE;
    static char[][] candy;
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] direction : directions) {
                    int nY = i + direction[0];
                    int nX = j + direction[1];

                    if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                        continue;
                    }

                    swap(i, j, nY, nX);

                    result = Math.max(result, check());

                    swap(nY, nX, i, j);
                }
            }
        }

        System.out.println(result);

    }

    private static int check() {
        int max = 0;
        int cnt = 1;
        for (int i = 0; i <N; i++) {
            cnt = 1;
            for (int j = 1; j < N; j++) {
                if(candy[i][j] == candy[i][j-1]){
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else
                    cnt = 1;
            }
        }
        for (int i = 0; i <N; i++) {
            cnt = 1;
            for (int j = 1; j < N; j++) {
                if(candy[j][i] == candy[j-1][i]){
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else
                    cnt = 1;
            }
        }

        return max;
    }

    private static void swap(int y, int x, int nY, int nX) {
        char temp = candy[y][x];
        candy[y][x] = candy[nY][nX];
        candy[nY][nX] = temp;
    }
}
