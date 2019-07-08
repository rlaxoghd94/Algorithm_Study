import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static int L, C;
    public static String[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);

        DFS(0, "");
    }

    public static void DFS(int idx, String password) {
        if (password.length() == L) {
            if (isPrintable(password))
               System.out.println(password);
            return;
        }

        if (idx >= alphabet.length)
            return;
        DFS(idx + 1, password + alphabet[idx]);
        DFS(idx + 1, password);
    }

    public static boolean isPrintable(String password) {
        int vowel, consonant;
        vowel = consonant = 0;

        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        } else {
            return false;
        }
    }
}