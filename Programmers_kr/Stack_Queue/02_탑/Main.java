
public class Main {


    public static void main(String[] args) {

    }

    public static int[] solution(int[] heights) {
        int heightLen = heights.length;
        int[] answer = new int[heightLen];

        for (int sender = heightLen - 1; sender > 0; sender--) {
            for (int receiver = 0; receiver < sender; receiver++) {
                if (heights[receiver] > heights[sender])
                    answer[sender] = receiver + 1;
            }
        }

        return answer;
    }
}