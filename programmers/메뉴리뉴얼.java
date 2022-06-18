package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[]{2, 3, 4});
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

    /**
     * orders	                                                course	    result
     * ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	    [2,3,4]	    ["AC", "ACDE", "BCFG", "CDE"]
     * ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	    ["ACD", "AD", "ADE", "CD", "XYZ"]
     * ["XYZ", "XWY", "WXA"]	                            [2,3,4]	    ["WX", "XY"]
     */

    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    static int max;

    static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (String order : orders) {
            for (int c : course) {
                combination("", order, c);
            }
        }

        for (int c : course) {
            max = Integer.MIN_VALUE;
            for (String s : map.keySet()) {
                if (s.length() == c) {
                    max = Math.max(max, map.get(s));
                }
            }
            if (max <=1)
                continue;
            List<String> list = map.keySet().stream().filter(s -> map.get(s) == max && s.length()==c).collect(Collectors.toList());
            result = Stream.concat(list.stream(), result.stream()).collect(Collectors.toList());
        }
        answer = result.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    static void combination(String sub, String str, int cnt) {
        if (cnt == 0) {
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            combination(sub + str.charAt(i), str.substring(i + 1), cnt - 1);
        }
    }
}
