package Chapter11;

import java.util.*;

public class MusyEatingLive {
    public static void main(String[] args) {

    }

    public static int solution(int[] food_times, long k) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> order = new LinkedList<>();
        for (int i=0; i<food_times.length; i++) {
            queue.add(food_times[i]);
            queue.add(i+1);
        }
        while (true) {
            long min = 100000000;
            for (int i=0; i<order.size(); i++) {
                int index = order.peek();
                if (min>food_times[index]) min = food_times[index];
                order.add(order.poll());
            }
        }
    }
}
