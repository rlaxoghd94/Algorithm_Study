import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int maxVal, N;
	public static int[] dp, t, p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 5];
		p = new int[N + 5];
		t = new int[N + 5];
		
		Arrays.fill(dp, 0);
		Arrays.fill(p, 0);
		Arrays.fill(t, 0);

		maxVal = 0;

		String[] tmp;
		for (int i = 1; i <= N; i++) {
			tmp = br.readLine().split(" ");
			t[i] = Integer.parseInt(tmp[0]);
			p[i] = Integer.parseInt(tmp[1]);
		}


		for (int i = 1; i <= N + 1; i++) {
			dp[i] = Math.max(dp[i], maxVal);
			dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);
			maxVal = Math.max(dp[i], maxVal);
		}
		System.out.println(maxVal);
	}
}