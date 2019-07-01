import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
     * Baekjoon: 1967 - Diameter of a Binary Tree
     * Approach: using Dynamic Programming and DFS, find the link chain with the most weight-sum value
     */

    private static final int MAX_RANGE = 10001;

    public static int N;
    public static ArrayList<Node>[] vector = new ArrayList[MAX_RANGE];
    public static int dp[] = new int[MAX_RANGE];
    static int v, u, r;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int from, to, val;

        for (int i = 1; i < MAX_RANGE; i++){
            vector[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            val = sc.nextInt();

            vector[from].add(new Node(to, val));
            vector[to].add(new Node(from, val));
        }

        DFS(1, 0);
        r = 0;

        dp = new int[MAX_RANGE];
        DFS(u, 0);
        System.out.println(r);
    }

    public static void DFS(int v, int sum) {
        dp[v] = sum;

        if (dp[v] > r) {
            r = dp[v];
            u = v;
        }

        for (Node node : vector[v]) {
            int next = node.to;
            int weight = node.weight;

            if (dp[next] == 0){
                DFS(next, sum + weight);
            }
        }
    }

    public static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}