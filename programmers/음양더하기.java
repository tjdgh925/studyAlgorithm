package programmers;

import java.util.HashMap;
import java.util.Map;

public class 음양더하기 {

    /**
     * 입출력
     * absolutes	signs	result
     * [4,7,12]	[true,false,true]	9
     * [1,2,3]	[false,false,true]	0
     */

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            int num = absolutes[i];
            num *= signs[i] ? 1 : -1;
            answer += num;
        }

        return answer;
    }


}
