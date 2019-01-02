import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] input;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// variable init HERE
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		input = new int[N][N];
		visited = new boolean[N][N];

		for (int[] i : input)
			Arrays.fill(i, 0);

		for (boolean[] i : visited)
			Arrays.fill(i, false);

		// take input matrix HERE
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while (st.hasMoreTokens()) {
				input[i][cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}
		br.close();
		st = null;

		// calculation HERE
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && input[i][j] == 1) {
					DFS(i, i, j);
				}
			}
		}

		printMatrix(input);

	}

	/*
	 * @DESC: Basically, if 1->3, this method block checks if 1->2, 2->3 makes
	 * sense and marks it in the matrix
	 */
	static void DFS(int start, int i, int j) {
		input[start][j] = 1;
		visited[start][j] = true;

		for (int k = 0; k < N; k++) {
			if (!visited[start][k] && input[j][k] == 1) {
				DFS(start, j, k);
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] a : matrix) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}

