import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, diff;
	public static int[][] stat;
	public static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[];

		// Take input HERE
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		stat = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 1; j <= N; j++)
				stat[i][j] = Integer.parseInt(tmp[j-1]);
		}
		diff = Integer.MAX_VALUE;
		comb(1, 0);
		
		System.out.println(diff);
	}

	public static void comb(int start, int depth) {
		if (depth == N / 2) {
			int teamStatDiff = getTeamStatDiff();
			diff = Math.min(diff, teamStatDiff);
			return;
		}

		for (int i = start; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static int getTeamStatDiff() {
		// TODO Auto-generated method stub
		int teamStart, teamLink;
		teamStart = teamLink = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(visit[i] && visit[j]) 
					teamStart += stat[i][j];
				
				if (!visit[i] && !visit[j]) 
					teamLink += stat[i][j];
			}
		}
		
		return Math.abs(teamStart - teamLink);
	}
}