import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
     * Baekjoon: 11726 - 2 x n Tiling
     * Algorithm: Dynamic Programming
     * Approach: use the following base cases:
     *   2x0 = 0
     *   2x1 = 1
     *   2x2 = 2
     *   2x3 = 3
     *   2x4 = 5
     *   ...
     *   2x9 = 55 (the 10th sequence of a fibonacci sequence is 55)
     *  -> notice how the pattern is similar to the fibonacci sequence
     */
    private static final int MAX = 1001;
    public static int [] dpArr = new int[MAX];
    public static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Arrays.fill(dpArr, 0);
        System.out.println(dp());
    }

    public static int dp() {
        if (N == 0)
            return 0;

        dpArr[1] = 1;
        dpArr[2] = 2;

        for (int i = 3; i <= N; i++) {
            dpArr[i] = (dpArr[i-2] + dpArr[i-1]) % 10007;
        }

        return dpArr[N];
    }
}