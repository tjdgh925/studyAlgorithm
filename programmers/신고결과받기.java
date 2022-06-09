package programmers;

import java.util.ArrayList;
import java.util.List;

public class 신고결과받기 {


    public static void main(String[] args) {
        String id_list[] = {"muzi", "frodo", "apeach", "neo"};
        String report[] = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
    }


    public static int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        int[] reportNum = new int[size];
        int[] answer = new int[size];
        List<List<String>> banHistory = new ArrayList<>();
        List<List<String>> reportHistory = new ArrayList<>();
        List<String> idList = List.of(id_list);
        for (int i = 0; i < size; i++) {
            banHistory.add(new ArrayList<>());
            reportHistory.add(new ArrayList<>());
        }

        for (String s : report) {
            String[] split = s.split(" ");
            String userA = split[0];
            String userB = split[1];
            int indexA = idList.indexOf(userA);
            int indexB = idList.indexOf(userB);

            if (banHistory.get(indexB).contains(userA)) {
                continue;
            }
            banHistory.get(indexB).add(userA);

            if (reportHistory.get(indexA).contains(userB)) {
                continue;
            }
            reportHistory.get(indexA).add(userB);
        }

        for (int i = 0; i < size; i++) {
            reportNum[i] = banHistory.get(i).size();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < reportHistory.get(i).size(); j++) {
                int index = idList.indexOf(reportHistory.get(i).get(j));
                if(reportNum[index] >= k)
                    answer[i]++;
            }
        }

        return answer;
    }


}
