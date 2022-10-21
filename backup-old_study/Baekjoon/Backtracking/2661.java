import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int N;
	public static ArrayList<String> ansList;
	public static boolean isEnd;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ansList = new ArrayList<String>();
		DFS("");
	}

	public static void DFS(String current) {
		if (isEnd)
			return;
		
		if (current.length() == N) {
			System.out.println(current);
			isEnd = true;
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (isAble(current + i))
				DFS(current + i);
		}
	}

	public static boolean isAble(String current) {
		int len = current.length();
		
		for (int i = 1; i <= len/2; i++) {
			String frontStr = current.substring(current.length()-i-i, current.length()-i);
			String laterStr = current.substring(current.length()-i, current.length());
			
			if (frontStr.equals(laterStr))
				return false;
		}
		
		return true;
	}
}