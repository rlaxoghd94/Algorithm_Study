import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
//        String[][] tickets = {
//                {"ICN", "JFK"},
//                {"HND", "IAD"},
//                {"JFK", "HND"}
//        };
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN","ATL"},
                {"SFO","ATL"},
                {"ATL","ICN"},
                {"ATL","SFO"}
        };
        String[] answer;
        answer = solution(tickets);
        printAns(answer);
    }

    public static void printAns(String[] ans) {
        System.out.println("---ANSWER---");
        for (String a : ans)
            System.out.print("\""+a+"\" ");
        System.out.println("\n-------------");
    }

    private static final int FROM = 0;
    private static final int TO = 1;

    static boolean[] v;

    public static String[] solution(String[][] tickets) {
        int ticketCount = 0;
        for (String[] tmp : tickets)
            ticketCount++;
        v = new boolean[ticketCount];
        Arrays.fill(v, false);
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add("ICN");
        DFS(tickets, ticketCount, "ICN", answerList);


        // finish touch
        int listSize = answerList.size();
        String[] answer = new String[listSize];
        for (int i = 0; i < listSize; i++)
            answer[i] = answerList.get(i);
        return answer;
    }

    public static void DFS(String[][] tickets, int ticketCount, String target, ArrayList<String> answerList) {
        if (ticketCount + 1 == answerList.size())
            return;

        ArrayList<Destination> tmp = new ArrayList<>();

        for (int from = 0; from < ticketCount; from++) {
            if (target.equals(tickets[from][FROM]) && !v[from])
                tmp.add(new Destination(tickets[from][TO], from));
        }
        if (tmp.size() > 1)
            Collections.sort(tmp);

        Destination dest = tmp.get(0);
        v[dest.idx] = true;
        answerList.add(dest.dest);

        DFS(tickets, ticketCount, dest.dest, answerList);
    }

    static class Destination implements Comparable<Destination> {
        String dest;
        int idx;

        public Destination(String dest, int idx) {
            this.dest = dest;
            this.idx = idx;
        }

        @Override
        public int compareTo(Destination o) {
            // originally, compareTo method sorts in Alphabetical order
            return this.dest.compareTo(o.dest);
        }
    }
}