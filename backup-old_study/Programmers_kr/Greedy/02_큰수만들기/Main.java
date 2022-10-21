public class Main {

    public static void main(String[] args) {
        System.out.println( solution("1231234", 3) );
    }

    public static String solution(String number, int k) {
        if (number.charAt(0) == '0')
            return "0";

        int idx = 0;
        char max = '0';
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < number.length()-k; i++) {
            max = '0';
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}