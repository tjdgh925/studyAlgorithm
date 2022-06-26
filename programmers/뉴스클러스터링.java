package programmers;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {


    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    static int solution(String str1, String str2) {
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();

        List<String> set1 = makeSet(s1);
        List<String> set2 = makeSet(s2);

        if (set1.size() == 0 && set2.size() == 0) {
            return 65536;
        }

        List<String> inter = new ArrayList<>();
        List<String> sum = new ArrayList<>();
        for (int i = 0; i < set1.size(); i++) {
            if (set2.contains(set1.get(i))) {
                inter.add(set1.get(i));
                set2.remove(set1.get(i));
            }
            sum.add(set1.get(i));
        }
        sum.addAll(set2);

        double a = (double) inter.size() / (double) sum.size();
        System.out.println(a);
        return (int) (a * 65536);
    }

    static List<String> makeSet(String str) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (!sub.matches("^[A-Z]*$")) {
                continue;
            } else answer.add(sub);
        }
        return answer;
    }
}
