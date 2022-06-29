package programmers;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] solution = solution(s);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    static int[] solution(String s) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(s, "{");

        while (st.hasMoreTokens()) {
            String temp = st.nextToken().replaceAll("[{}]", "");
            StringTokenizer tst = new StringTokenizer(temp, ",");
            while (tst.hasMoreTokens()) {
                int num = Integer.parseInt(tst.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {return o2.getValue().compareTo(o1.getValue());});

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] =list.get(i).getKey();
        }
        return answer;
    }

}
