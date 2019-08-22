import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

    }

    /*
     * @Desc - Using only N, +/-/%/*, and brackets, return the least amount of N needed to represent 'number'
     */
    public int solution(int N, int number) {
        bfs(N, number);
        return minCount < 9 ? minCount : -1;
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static int count = 0, minCount = 9;

    private static void bfs(int N, int number) {
        if (count >= minCount)
            return;

        if (list.size() >= minCount)
            return;

        int lastNum = (list.size() == 0) ? 0 : list.get(list.size() - 1);

        if (lastNum == number) {
            minCount = Math.min(count, minCount);
            return;
        }

        int n = 0, addCount = 0;

        for (int i = 1; i < 1000000; i *= 10) {
            addCount++;
            if (count + addCount >= minCount)
                continue;

            n += (N * i);
            count += addCount;

            // 덧셈
            list.add(lastNum + n);
            bfs(N, number);
            list.remove(list.size() - 1);

            // 뻴셈
            if (lastNum - n != 0) {
                list.add(lastNum - n);
                bfs(N, number);
                list.remove(list.size() - 1);
            }

            // 곱셈
            list.add(lastNum * n);
            bfs(N, number);
            list.remove(list.size() - 1);

            // 나눗셈
            if (lastNum / n != 0) {
                list.add(lastNum / n);
                bfs(N, number);
                list.remove(list.size() - 1);
            }

            count -= addCount;
        }
        return;
    }
}
