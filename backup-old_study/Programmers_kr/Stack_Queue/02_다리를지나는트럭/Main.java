import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
        int answer = 0;

        int[] truck_weights = {7, 4, 5, 6};
        answer = solution(2, 10, truck_weights);

//        answer = solution();

        System.out.println(answer);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, weightLeft = weight, time = 0;
        Queue<Truck> offBridge = new LinkedList<>();
        List<Truck> onBridge = new ArrayList<>();

        for (int truckWeight : truck_weights)
            offBridge.add(new Truck(truckWeight, bridge_length));

        /*
         * @Desc - (totalWeight:int) = total weight of the trucks on the bridge at the moment
         */

        Truck truck = null;

        while (!(onBridge.isEmpty() && offBridge.isEmpty())) {
            time++;

            if (!onBridge.isEmpty() && onBridge.get(0).time <= 0) {
                weightLeft += onBridge.get(0).weight;
                onBridge.remove(0);
            }

            if (!offBridge.isEmpty() && weightLeft - offBridge.peek().weight >= 0) {
                weightLeft -= offBridge.peek().weight;
                onBridge.add(offBridge.poll());
            }

            for (int i = 0; i < onBridge.size(); i++) {
                truck = onBridge.get(i);
                truck.time--;
            }
        }

        return answer = time;
    }

    static class Truck {
        int weight, time;

        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}