import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		make_one();
	}

	public static void make_one() {
		int dp[] = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) 
				dp[i] = dp[i / 2] + 1;

			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) 
				dp[i] = dp[i / 3] + 1;
		}
		System.out.println(dp[N]);
	}
}