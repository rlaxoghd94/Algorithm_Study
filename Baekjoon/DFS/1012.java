import java.util.Scanner;

public class Main {

	static int T, N, M, K, CNT;
	static int[][] inputMatrix;
	static boolean[][] checkMap;
	private static final int dx[] = { 0, 1, 0, -1 };
	private static final int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			CNT = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			inputMatrix = new int[N][M];
			checkMap = new boolean[N][M];

			// where organic cabbages are planted
			for (int j = 0; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				inputMatrix[y][x] = 1;
			}

			// traverse through the map
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (inputMatrix[j][k] == 1 && !checkMap[j][k]) {
						// dfs if not visited
						DFS(k, j);
						CNT++;
					}
				}
			}
			printMatrix(inputMatrix);
			System.out.println(CNT);
		}
		sc.close();
	}

	static void DFS(int x, int y) {
		checkMap[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX >= 0 && newY >= 0 && newY < N && newX < M)
				if (inputMatrix[newY][newX] == 1 && !checkMap[newY][newX])
					DFS(newX, newY);
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
