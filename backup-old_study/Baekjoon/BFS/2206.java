import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    private static final int MAX = 1001;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static int N, M;
    public static int[][] input = new int [MAX][MAX];
    // if a wall breaks [n][m][0] = true, else [n][m][1] = true;
    public static boolean[][][] visit = new boolean[MAX][MAX][2];
    public static boolean isSuccess;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int[] arr : input)
            Arrays.fill(arr, -1);

        for (boolean [][] dArr: visit)
            for (boolean [] arr : dArr)
                Arrays.fill(arr, false);

        String tmp = "";
        for (int i = 0; i < N; i++) {
            tmp = br.readLine();
            for (int j = 0; j < M; j++)
                try {
                    input[i][j] = tmp.charAt(j) - '0';
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(tmp);
                }
        }

        int minSteps = BFS();
        System.out.println(isSuccess ? minSteps : -1);
    }

    public static int BFS() {

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, 0));

        visit[0][0][0] = visit[0][0][1] = true;
        isSuccess = false;
        int step = 0;

        while (!q.isEmpty() && !isSuccess) {
            step++;
            int size = q.size();


            for (int k = 0; k < size; k++) {
                Node node = q.poll();

                if (node.x == M - 1 && node.y == N - 1) {
                    isSuccess = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    // check range
                    if (ny > -1 && ny < N && nx > -1 && nx < M) {
                        // if faced a wall
                        if (input[ny][nx] == 1) {
                            // if wall hasn't been broken and the coordinate hasn't been visited
                            if (node.destroy < 1 && !visit[ny][nx][1]) {
                                visit[ny][nx][1] = true;
                                q.add(new Node(nx, ny, 1));
                            }
                        }
                        // if it's not a wall
                        else {
                            if (!visit[ny][nx][node.destroy]) {
                                visit[ny][nx][node.destroy] = true;
                                q.add(new Node(nx, ny, node.destroy));
                            }
                        }
                    }

                }
            }
        }
        return step;
    }

    public static class Node {
        int x, y, destroy;

        Node (int x, int y, int destroy) {
            this.x = x;
            this.y = y;
            this.destroy = destroy;
        }
    }


    public static void printInput() {

        System.out.println("\n\n[+] Printing input arr...");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print("[" + input[i][j] + "]");
            System.out.println();
        }
        System.out.println("[+] Priting complete...");
    }

}