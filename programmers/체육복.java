package programmers;

import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[]{3});
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] have = new boolean[n];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Arrays.fill(have, true);
        for (int i = 0; i < lost.length; i++) {
            have[lost[i] - 1] = false;
        }
        for (int i = 0; i < reserve.length; i++) {
            if (!have[reserve[i] - 1]) {
                have[reserve[i] - 1] = true;
                reserve[i] = -1;
            }
        }

        for (int l : lost) {
            int before  = (l - 1 == 0) ? 0 : l - 1;
            int after = l == n ? l : l+1;
            for (int i = 0; i < reserve.length; i++) {
                if(reserve[i] == before){
                    have[l - 1] = true;
                    reserve[i] = -1;
                    break;
                }
                if (reserve[i] == after) {
                    have[l - 1] = true;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        for (boolean h : have) {
            if(h)
                answer++;
        }

        return answer;
    }

}
