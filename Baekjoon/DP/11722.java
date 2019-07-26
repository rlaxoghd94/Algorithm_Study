import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] input, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        input = new int[N];
        count = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            input[i] = stoi(tmp[i]);
        for (int i = 0; i < N; i++) {
            count[i] = 1;
            for (int j = 0; j < N; j++) {
                if (input[i] < input[j] && count[j]+1 > count[i])
                    count[i] = count[j] + 1;
            }
        }
        int result = count[0];

        for (int i : count)
            result = Math.max(result, i);

        System.out.println(result);
        br.close();
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}