import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[][] map;
    public static int[][] dp;
    public static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int[] i : dp)
            Arrays.fill(i, 0);

        for (int i = 1; i <= N; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(tmp[j - 1]);
                dp[i][j] = map[i][j] + dp[i][j - 1];
            }
        }

        K = Integer.parseInt(br.readLine().split(" ")[0]);

        int startX, startY, endX, endY, result;
        for (int i = 0; i < K; i++) {
            tmp = br.readLine().split(" ");
            startX = Integer.parseInt(tmp[0]);
            startY = Integer.parseInt(tmp[1]);
            endX = Integer.parseInt(tmp[2]);
            endY = Integer.parseInt(tmp[3]);

            result = 0;

            for (int row = startX; row <= endX; row++) {
                result += dp[row][endY] - dp[row][startY - 1];
            }
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }
}