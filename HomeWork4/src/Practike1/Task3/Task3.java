package Practike1.Task3;

import java.time.LocalTime;
import java.util.PriorityQueue;

public class Task3 {
    public static void main(String[] args) {
        PriorityQueue<User> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new User("Марат", LocalTime.now().toString(),5));
        priorityQueue.add(new User("Макс", LocalTime.now().toString(),1));

        System.out.println(priorityQueue);

    }
}
