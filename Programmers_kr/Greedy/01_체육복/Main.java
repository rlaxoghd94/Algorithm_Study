import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		solution(5, lost, reserve);
	}

	static int solution(int n, int[] lost, int[] reserve) {
		int wholeClass[] = new int[n + 2];
		// Arrays.fill(wholeClass, 1);
		for (int i = 0; i < wholeClass.length; i++) {
			wholeClass[i] = 1;
		}

		for (int i = 0; i < lost.length; i++) {
			wholeClass[lost[i]] -= 1;
		}
		for (int i = 0; i < reserve.length; i++) {
			wholeClass[reserve[i]] += 1;
		}

		for (int i = 1; i < wholeClass.length - 1; i++) {
			if (wholeClass[i] == 2) {
				if (wholeClass[i - 1] == 0) {
					wholeClass[i - 1]++;
					wholeClass[i]--;
				} else if (wholeClass[i + 1] == 0) {
					wholeClass[i + 1]++;
					wholeClass[i]--;
				}
			}
		}

		int answer = 0;
		for (int i = 1; i < wholeClass.length - 1; i++) {
			if (wholeClass[i] > 0) {
				answer++;
			}
		}
		return answer;
	}

	static void printWholeClass(int class_w[]) {
		String print_fmt = "[%d] ";
		for (int i = 1; i < class_w.length - 1; i++) {
			System.out.print(String.format(print_fmt, class_w[i]));
		}
		System.out.println("\n");
	}
}
