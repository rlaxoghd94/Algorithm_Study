import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static int[][] map = new int[5][5];
    public static HashSet<String> possibilities = new HashSet<>();
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp;
        for (int i = 0; i < 5; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                solve(i, j, 0, "");


        System.out.println(possibilities.size());
   }

   public static void solve(int x, int y, int depth, String s) {
        if (depth == 6) {
            // HashSet does not allow data redundancy
            possibilities.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > 4 || ny > 4)
                continue;

            solve(nx, ny, depth + 1, s + map[nx][ny]);
        }
   }
}