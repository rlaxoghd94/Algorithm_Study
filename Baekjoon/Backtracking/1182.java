import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int N, S;
    public static int[] val = new int[20];
    public static int cnt, currentSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        Arrays.fill(val, -99);

        for (int i = 0; i < N; i++)
            val[i] = sc.nextInt();

        cnt = currentSum = 0;

        DFS(0);
        System.out.println(cnt);
    }


    public static void DFS(int idx) {
        if (idx == N)
            return;

        // if matched, cnt increases
        if (currentSum + val[idx] == S)
            cnt++;

        // try DFS without current val
        DFS(idx + 1);

        // try DFS with current val
        currentSum += val[idx];
        DFS(idx + 1);

        // this is backtracking HERE
        currentSum -= val[idx];
    }
}