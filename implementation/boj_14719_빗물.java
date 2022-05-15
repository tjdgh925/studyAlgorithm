package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] block = new int[H][W];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int black = Integer.parseInt(st.nextToken());
            while (black != 0)
                block[H - (black--)][i] = 1;
        }


        for (int i = 0; i < H; i++) {
            int start = -1;
            for (int j = 0; j < W; j++) {
                if (block[i][j] == 1) {
                    if (start != -1 && j - start > 1) {
                        result += j - start - 1;
                    }
                    start = j;
                }
            }
        }
            System.out.println(result);
    }
}
