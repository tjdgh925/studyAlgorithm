package programmers;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    static int MAX = 10001;
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] seq2 = {1,3,4,5};
        int[] seq3 = {3,1,2,4,5};

        List<Integer> One = new ArrayList<>();
        List<Integer> Two = new ArrayList<>();
        List<Integer> Three = new ArrayList<>();

        for(int i = 1; i <= MAX; i++){
            int num = i % 5;
            if(num == 0) {
                One.add(5);
            } else{
                One.add(num);
            }
        }

        for(int i = 0; i <= MAX/2; i++){
            int num2 = i%4;
            int num3 = i%5;

            Two.add(2); Two.add(seq2[num2]);
            Three.add(seq3[num3]); Three.add(seq3[num3]);
        }


        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt = Integer.MIN_VALUE;
        for(int i = 0; i < answers.length; i++){
            if (answers[i] == One.get(i)) {
                cnt1++;
            }
            if (answers[i] == Two.get(i)) {
                cnt2++;
            }
            if (answers[i] == Three.get(i)) {
                cnt3++;
            }

            cnt = Math.max(cnt, cnt1);
            cnt = Math.max(cnt, cnt2);
            cnt = Math.max(cnt, cnt3);
        }

        if (cnt == cnt1) {
            answer.add(1);
        }
        if (cnt == cnt2) {
            answer.add(2);
        }
        if (cnt == cnt3) {
            answer.add(3);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


