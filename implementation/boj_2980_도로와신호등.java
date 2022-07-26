package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2980_도로와신호등 {

    static class Light {
        int red;
        int green;

        public Light(int red, int green) {
            this.red = red;
            this.green = green;
        }
    }

    static int N, L;
    static int cnt = 0, cur = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Light[] lights = new Light[L + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            lights[D] = new Light(R, G);
        }

        while (cur < L) {
            ++cnt;
            ++cur;

            if (lights[cur] != null) {
                int time = cnt % (lights[cur].green + lights[cur].red);

                if (time <= lights[cur].red)
                    cnt += lights[cur].red - time;
            }
        }
        System.out.println(cnt);
    }
}
