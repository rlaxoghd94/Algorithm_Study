public class Main {

	public static void main(String[] args) {

		// System.out.println(solution("1924", 2));
		// System.out.println(solution("1231234", 3));
		// System.out.println(solution("4177252841", 4));
		// System.out.println(solution("4177252841", 1));
		// System.out.println(solution("321", 1));
		System.out.println(solution("198387562983625638", 3));
	}

	/*
	 * ERROR PRONE: the integer range overflow occurs and the whole program fails.
	 * SOLUTION: for better code optimization, try bfs for definite solution.
	 */
	static String solution(String number, int k) {
		String answer = "";
		int n_length = number.length();
		int K = k;

		/*
		 * if number = 12345 and k = 2, largest combination possible is when the
		 * first digit comes from idx:0 ~ n_length-k
		 */
		int maxIdx = 0, tempMax = 0;
		for (int i = 0; i < n_length - k; i++) {
			int tempVal = Character.getNumericValue(number.charAt(i));
			if (tempMax < tempVal) {
				tempMax = tempVal;
				maxIdx = i;
			}
		}

		if (maxIdx == k)
			return number.substring(maxIdx, n_length - 1);

		/*
		 * for the remainder, select the maximum integer until an appropriate
		 * length is met
		 */
		k -= maxIdx;
		answer = number.substring(maxIdx, n_length);

		StringBuilder sb;
		int startIdx = 1;
		while (k != 0) {
			tempMax = 0;
			maxIdx = 0;
			
			for (int i = startIdx; i < answer.length(); i++) {
				sb = new StringBuilder(answer);
				sb.deleteCharAt(i);
				int tempVal = Integer.parseInt(sb.toString());
				if (tempVal > tempMax) {
					tempMax = tempVal;
					maxIdx = i;
				}
			}
			answer = String.valueOf(tempMax);
			k--;
			startIdx++;
		}
		return answer;
	}
}

