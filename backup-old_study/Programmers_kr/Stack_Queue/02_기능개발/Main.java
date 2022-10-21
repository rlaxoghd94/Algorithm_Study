import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        printAnswer( solution(progresses, speeds) );
    }

    static void printAnswer (int[] answer) {
        System.out.println("------------Answer--------------");
        for (int i : answer) {
            System.out.print("["+i+"]");
        }
        System.out.println("\n-------------------------------");
    }

//    public static int[] solution(int[] progresses, int[] speeds) {
//        int answer[] = {};
//
//        Queue<Work> workQueue = new LinkedList<>();
//        Map<Integer, Integer> log = new HashMap<>();
//
//        for (int i = 0; i < progresses.length; i++)
//            workQueue.offer(new Work(progresses[i], speeds[i]));
//
//        int delayDate = 0;
//
//        while (!workQueue.isEmpty()) {
//            Work work = workQueue.poll();
//            int progress = work.progress;
//            int speed = work.speed;
//            int duration = 0;
//            while ( progress < 100 ) {
//                progress += speed;
//                duration++;
//            }
//
//            duration = Math.max(duration, delayDate);
//            delayDate = duration;
//
//            if (log.containsKey(duration)) {
//                int workCnt = log.get(duration);
//                log.put(duration, workCnt + 1);
//            } else {
//                log.put(duration, 1);
//            }
//        }
//
//        // casting hashmap to integer array HERE
//        ArrayList<Integer> checker = new ArrayList<>();
//        answer = new int[log.size()];
//        int i = 0;
//        for (Map.Entry<Integer, Integer> entry : log.entrySet()) {
//            System.out.println("\t" + entry.getValue());
//            checker.add(entry.getValue());
//            answer[i] = entry.getValue();
//        }
//
//        for (int a : checker) {
//            System.out.println("\t\t" + a);
//        }
//
//        answer = checker.stream().mapToInt(Integer::intValue).toArray();
//
//        return answer;
//    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int len = progresses.length;

        int num = 0;
        for(int i = 0; i <= len; i++){
            if(i == len){
                q.add(num);
                break;
            }
            if(progresses[i] >= 100){
                num++;
                continue;
            }
            if(num != 0){
                q.add(num);
            }

            num = 0;
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0){
                day++;
            }

            for(int j = i; j < len; j++){
                progresses[j] += (day * speeds[j]);
            }
            num++;
        }

        int[] answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = q.remove();
        }
        return answer;
    }

    static class Work {
        int progress, speed;

        Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}