package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1700_멀티탭스케줄링 {

    static int N, K;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int num = list.get(i);
            if(set.contains(num)) continue;
            if (set.size() < N) {
                set.add(num);
                continue;
            }

            int max = -1, idx = -1;
            for (Integer s : set) {
                int tmp = 0;
                List<Integer> remain = list.subList(i + 1, K);
                if (remain.contains(s)) {
                    tmp = remain.indexOf(s) + 1;
                } else {
                    tmp = K - i - 1;
                }

                if (tmp > max) {
                    max = tmp;
                    idx = s;
                }
            }

            set.remove(idx);
            set.add(num);
            cnt++;
        }
        System.out.println(cnt);
    }
}
