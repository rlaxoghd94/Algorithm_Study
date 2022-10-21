import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(1);

        printList(list);

        list = generateParenthesis(2);
        printList(list);

        list = generateParenthesis(3);
        printList(list);
    }

    public static void printList(List<String> list) {
        for (String val : list)
            System.out.print(val + "\t");

        System.out.println("\n");
    }
    /*
     * Approach: Backtracking via DFS
     *
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list, n, "", 0, 0);

        return list;
    }

    public static void generate(List<String> list, int max, String curr, int open, int close) {
        if (curr.length() == max * 2) {
            list.add(curr);
            return;
        }

        if (open < max) {
            generate(list, max, curr + "(", open + 1, close);
        }

        if (close < max && close < open) {
            generate(list, max, curr + ")", open, close + 1);
        }
    }
}
