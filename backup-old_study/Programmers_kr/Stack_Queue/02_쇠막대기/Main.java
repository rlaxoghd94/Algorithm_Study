import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        String input = "()(((()())(())()))(())";
        int answer = solution(input);

        System.out.println(answer);
    }

    public static int solution(String arrangement) {
        String cpArrangement = arrangement.replace("()", "0");
        int answer = 0;
        ArrayList<Character> arrList = new ArrayList<>();

        for (char c : cpArrangement.toCharArray()) {
            arrList.add(c);
        }

        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) == '(') {
                stack.add(arrList.get(i));
            } else if (arrList.get(i) == ')') {
                stack.remove(stack.size() - 1);
                answer++;
            } else if (arrList.get(i) == '0') {
                answer += stack.size();
            }
        }

        return answer;
    }
}