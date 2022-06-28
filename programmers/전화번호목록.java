package programmers;

import java.util.*;

public class 전화번호목록 {

    public static void main(String[] args) {
        solution(new String[]{"119", "97674223", "1195524421"});
    }

    static boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String str : phone_book) {
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i);
                if (map.containsKey(temp)) {
                    return false;
                }
            }
        }
        return true;
    }
}
