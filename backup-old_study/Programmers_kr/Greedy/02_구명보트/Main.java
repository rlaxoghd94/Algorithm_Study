import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		int[] people = {70, 50, 50, 80};
		int[] people = { 70, 80, 50 };

		System.out.println(solution(people, 100));
	}

	public static int solution(int[] people, int limit) {
		int count = 0, index = people.length - 1;
		
		Arrays.sort(people);
	
		for (int i = 0; i <= index; i++, count++) {
			while (index > i && people[i] + people[index--] > limit)
				count++;
		}

		return count;
	}
}