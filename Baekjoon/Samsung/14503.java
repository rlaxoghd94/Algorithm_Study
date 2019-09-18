import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int r, c, d;
    static int[][] map;
    static int turnCnt = 0;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        String[] temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine().split(" ");
        n = stoi(temp[0]);
        m = stoi(temp[1]);

        map = new int[n][m];

        temp = br.readLine().split(" ");
        r = stoi(temp[0]);
        c = stoi(temp[1]);
        d = stoi(temp[2]);

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                map[i][j] = stoi(temp[j]);
        }

        solution();
//        printMap();
    }

    static void printMap() {
        System.out.println("[+] Printing...");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(".............. complete.");
    }

    static void solution() {
        /*
         * 0: empty space
         * 1: wall
         * 2: cleaned space
         */

        while (true) {
            if (turnCnt == 4) {
                int backX, backY;
                // either dx[d] or dy[d] is going to be 0
//                backX = r - dx[d] - dx[d];
//                backY = c - dy[d] - dy[d];
                backX = r - dx[d];
                backY = c - dy[d];
                // Condition #2-d
                // cannot backup anymore b/c of the wall
                if (map[backX][backY] == 1) {
                    System.out.println(getCleanArea());
                    return;
                } else {
                    // Condition #2-c
                    // move back but maintain direction as it is
                    setRobot(backX, backY, d, 0);
                }
            }

            // Condition #1
            if (map[r][c] == 0)
                map[r][c] = 2;

            // Condition #2
            int ld = (d + 3) % 4;
            int nx = r + dx[ld];
            int ny = c + dy[ld];

            // Condition #2-a
            // Condition #2-b
            if (map[nx][ny] == 0)
                setRobot(nx, ny, ld, 0);
            else
                setRobot(r, c, ld, turnCnt + 1);
        }
    }

    private static int getCleanArea() {
        int areaCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    areaCnt++;
            }
        }
        return areaCnt;
    }

    public static void setRobot(int nextX, int nextY, int nextD, int nextCount) {
        r = nextX;
        c = nextY;
        d = nextD;
        turnCnt = nextCount;
    }


    /*
     * useful functions
     */
    public static int stoi(String val) {
        return Integer.parseInt(val);
    }

    public static String itoa(int val) {
        return String.valueOf(val);
    }
}