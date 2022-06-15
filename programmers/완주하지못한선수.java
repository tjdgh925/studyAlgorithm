package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    static String solution(String[] participant, String[] completion) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            int cnt = 1;
            if (map.containsKey(p)) {
                cnt = map.get(p) + 1;
            }
            map.put(p, cnt);
        }

        for (String c : completion) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c)-1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                result.append(s);
            }
        }

        /*
        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if (completion[i].equals(participant[j])) {
                    participant[j] = "";
                    break;
                }
            }
        }

        for (String s : participant) {
            if (!s.equals("")) {
                result.append(s);
            }
        }
        */

        /*
        List<String> P = new ArrayList<>(List.of(participant));

        List<String> C = List.of(completion);

        C.stream().forEach(P::remove);
         */

        return result.toString();
    }
}
