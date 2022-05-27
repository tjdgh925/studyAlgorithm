package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11000_강의실배정 {
    static int N;
    static class Time{
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, e);
        }
        Arrays.sort(times, (t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);


        for (int i = 1; i < N; i++) {
            if (pq.peek() <= times[i].start) {
                pq.poll();
            }
            pq.offer(times[i].end);
        }

        System.out.println(pq.size());

    }
}
