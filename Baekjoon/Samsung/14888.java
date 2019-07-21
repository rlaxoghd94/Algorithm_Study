import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int N;
	public static int[] input, op;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input = new int[N];
		op = new int[4];
		list = new ArrayList<Integer>();

		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(tmp[i]);
		}

		tmp = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(tmp[i]);
		}

		DFS(1, input[0]);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	public static void DFS(int x, int sum) {

		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				switch (i) {
				case 0: // +
					DFS(x + 1, sum + input[x]);
					break;
				case 1: // -
					DFS(x + 1, sum - input[x]);
					break;
				case 2: // *
					DFS(x + 1, sum * input[x]);
					break;
				case 3: // /
					DFS(x + 1, sum / input[x]);
					break;
				}
				op[i]++;
			}
		}

		if (x == N) {
			list.add(sum);
		}
	}
}