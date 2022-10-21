import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private final static int MAX = 15;

	public static int N, possibility;
	public static boolean isEnd;
	// since you can only put 1 queen per row, no need to make the board 2D
	public static int[] board = new int[MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			board = new int[MAX];
			board[1] = i;

			DFS(1);
		}

		System.out.println(possibility);

	}

	public static void DFS(int row) {
		if (row == N) {
			possibility++;
		} else {
			for (int i = 1; i <= N; i++) {
				board[row + 1] = i;
				if (isAble(row + 1)) {
					DFS(row + 1);
				} else {
					board[row + 1] = 0;
				}
			}
		}
		/*
		 * This is where backtracking occurs So, delete the visit record HERE
		 */
		board[row] = 0;
	}

	public static boolean isAble(int row) {
		for (int i = 1; i < row; i++) {
			if (board[i] == board[row])
				return false;

			if (Math.abs(board[i] - board[row]) == Math.abs(i - row))
				return false;

		}
		
		return true;
	}
}