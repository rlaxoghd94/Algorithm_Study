import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String answer = solution(participant, completion);

        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> playerMap = new HashMap<>();
        addParticipants(playerMap, participant);
        removeCompletion(playerMap, completion);

        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            if (entry.getValue() != 0)
                answer = entry.getKey();
        }

        return answer;
    }

    public static void addParticipants(Map<String, Integer> playerMap, String[] participant) {
        for (String p : participant) {
            if (playerMap.containsKey(p)) {
                int mapVal = playerMap.get(p);
                playerMap.put(p, mapVal + 1);
            } else {
                playerMap.put(p, 1);
            }
        }
    }

    public static void removeCompletion(Map<String, Integer> playerMap, String[] completion) {
        for (String c : completion) {
            int mapVal = playerMap.get(c);
            playerMap.put(c, mapVal - 1);
        }
    }
}