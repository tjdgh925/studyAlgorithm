package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] record) {
        Map<String, String> id = new HashMap<>();
        List<String> chats = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            String command = split[0];

            if (command.equals("Enter")) {
                id.put(split[1], split[2]);
                chats.add(split[1]+"&님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                chats.add(split[1]+"&님이 나갔습니다.");
            } else if (command.equals("Change")) {
                id.replace(split[1], split[2]);
            }
        }

        String[] answer = new String[chats.size()];
        for (int i = 0; i < chats.size(); i++) {
            String str[] = chats.get(i).split("&");
            String user = id.get(str[0]);
            String message = user + str[1];
            answer[i] = message;
        }

        return answer;
    }


}
