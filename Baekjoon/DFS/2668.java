import java.util.*;

public class Main {
    static int N, last;
    static int[] input;
    static boolean[] visited;
    static ArrayList<Integer> arrList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        input = new int[N + 1];
        visited = new boolean[N + 1];
        arrList = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            input[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            last = i;
            DFS(i);
            visited[i] = false;
        }

        Collections.sort(arrList);

        System.out.println(arrList.size());
        for (int i : arrList) {
            System.out.println(i);
        }
    }

    public static void DFS(int i) {
        if (!visited[input[i]]) {
            visited[input[i]] = true;
            DFS(input[i]);
            visited[input[i]] = false;
        }

        if (input[i] == last) {
            arrList.add(last);
        }
    }
}