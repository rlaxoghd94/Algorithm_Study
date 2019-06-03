import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, GLOBAL_CNT = 1;
	static int[][] input;
	static boolean[][] checkMap;

	private static final int dx[] = { 0, 1, 0, -1 };
	private static final int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
        // Variable init
		N = sc.nextInt();
		input = new int[N][N];
		checkMap = new boolean[N][N];
		for (int[] a : input)
			Arrays.fill(a, 0);

		for (boolean[] a : checkMap)
			Arrays.fill(a, false);

		String inputRow = "";
		for (int i = 0; i < N; i++) {
			inputRow = sc.next();
			for (int j = 0; j < N; j++) {
				input[i][j] = Character.getNumericValue(inputRow.charAt(j));
			}
			inputRow = "";
		}

		// Start traversing HERE
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] == 1 && !checkMap[i][j]) {
					DFS(i, j);
					GLOBAL_CNT++;
				}
			}
		}

        // Start counting and sorting HERE
		int ans[] = new int[GLOBAL_CNT];
		Arrays.fill(ans, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] != 0)
					ans[input[i][j]]++;
			}
		}
		Arrays.sort(ans);
        
        // Print answer HERE
		System.out.println(GLOBAL_CNT - 1);
		for (int i = 0; i < GLOBAL_CNT; i++) {
			if (ans[i] != 0)
				System.out.println(ans[i]);
		}
	}

	public static void DFS(int x, int y) {
		checkMap[x][y] = true;
		input[x][y] = GLOBAL_CNT;

		for (int i = 0; i < dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			// Range condition
			if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
				// House found!
				if (input[newX][newY] == 1 && !checkMap[newX][newY]) {
					DFS(newX, newY);
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println("----------Matrix----------");
		for (int[] a : matrix) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
