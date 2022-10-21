import java.util.Scanner;

public class Main {
    public static int N, possibilities;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N][N];
        possibilities = 0;
        placeQueen(0);


        System.out.println(possibilities);
    }


    public static void placeQueen(int queenCnt) {
        if (queenCnt == N) {
            possibilities++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isAble(queenCnt, i))
                continue;

            visited[queenCnt][i] = true;
            placeQueen(queenCnt + 1);
            visited[queenCnt][i] = false;
        }
    }

    /*
     * @Desc - we don't have to check the bottom b/c we place the queen in a sequential order from row 0 to row N
     *   which means, no queen should've been place below what we have just place previously
     */

    public static boolean isAble(int x, int y) {
        int tx, ty;

        // upward
        tx = x-1;
        ty = y;
        while (tx > -1) {
            if (visited[tx--][ty])
                return false;
        }

        tx = x-1;
        ty = y-1;
        //left diagonal
        tx = x;
        ty = y;
        while (ty > -1 && tx > -1) {
            if (visited[tx--][ty--])
                return false;
        }

        //right diagonal
        tx = x-1;
        ty = y+1;
        while (tx > -1 && ty < N) {
            if (visited[tx--][ty++])
                return false;
        }

        return true;
    }
}