public class Main {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123", "456", "789"};

        boolean answer = solution(phone_book);

        System.out.println(answer);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        int aLen, bLen;
        for (int i = 0; i < phone_book.length; i++) {
            aLen = phone_book[i].length();
            for (int j = 0; j < phone_book.length; j++) {
                if (i != j) {
                    bLen = phone_book[j].length();
                    if (aLen > bLen)
                        continue;
                    String subString = phone_book[j].substring(0, aLen);
                    if (subString.contains(phone_book[i]))
                        return false;
                }
            }
        }

        return answer;
    }
}