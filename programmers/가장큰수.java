package programmers;

import java.util.*;

public class 가장큰수 {

    static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] temp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return ((o2+o1).compareTo(o1+o2));
            }
        });

        if(temp[0].equals("0")){
            return "0";
        }

        for(String s : temp){
            answer.append(s);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }
}
