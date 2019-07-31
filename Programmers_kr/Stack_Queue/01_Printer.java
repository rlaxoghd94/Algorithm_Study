import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int[] input, count;

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
//
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int answer = 1;
        for (int task : priorities)
            queue.add(task);

        System.out.println(queue);

        while(!queue.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                System.out.println("priorities[i]: " + priorities[i] + ", queue.peek: " + queue.peek());
                if (priorities[i] == (int)queue.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}