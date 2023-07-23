package Practice1.Task3;

import java.time.LocalTime;
import java.util.PriorityQueue;

public class Task3 {
    public static void main(String[] args) {
        Server server = new Server(new PriorityQueue<>());
        server.addRequest(new User("Марат", LocalTime.now().toString(),1));
        server.addRequest(new User("Максим", LocalTime.now().toString(),3));
        server.addRequest(new User("Иван", LocalTime.now().toString(),2));
        server.showStatistic();
    }
}
