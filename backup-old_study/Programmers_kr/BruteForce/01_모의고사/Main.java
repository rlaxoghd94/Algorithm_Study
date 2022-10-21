import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};

        int[] answer = solution(answers);

        System.out.print("[+] Answer Printing...\n   -> ");
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println("\n--------------------------");
    }

    public static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == a[i%a.length]) {score[0]++;}
            if(answers[i] == b[i%b.length]) {score[1]++;}
            if(answers[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
//
//    public static int[] solution(int[] answers) {
//        int[] answer = {};
//        int[] one = {1, 2, 3, 4, 5};
//        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
//        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//        int oneLen = one.length, twoLen = two.length, threeLen = three.length;
//
//        int[] check = new int[3];
//        Arrays.fill(check, 0);
//
//        for (int i = 0; i < answers.length; i++) {
//            if (answers[i] == one[i % oneLen])
//                check[0]++;
//            if (answers[i] == two[i % twoLen])
//                check[1]++;
//            if (answers[i] == three[i % threeLen])
//                check[2]++;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i : check)
//            max = Math.max(i, max);
//
//        int maxCnt = 0;
//        for (int i : check)
//            if (i == max)
//                maxCnt++;
//
//        answer = new int[maxCnt];
//        int maxIdx = 0;
//        for (int i = 0; i < check.length; i++) {
//            if (check[i] == max) {
//                answer[maxIdx] = i + 1;
//                maxIdx++;
//            }
//        }
//
//        Arrays.sort(answer);
//
//        return answer;
//    }
}