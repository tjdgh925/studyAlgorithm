package programmers;

import java.util.*;

public class 소수찾기 {

    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visit;
    public int solution(String numbers) {
        arr = new char[numbers.length()];
        visit = new boolean[numbers.length()];

        for(int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }

        back("",0);


        return set.size();
    }

    static void back(String str,int depth){
        int num;
        if(str != ""){
            num = Integer.parseInt(str);
            if(check(num)) set.add(num);
        }

        if(depth == arr.length) return;

        for(int i = 0; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                back(str+ arr[i], depth+1);
                visit[i] = false;
            }
        }
    }

    static boolean check(int num){
        if(num==1||num==0) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }

        return true;
    }
}