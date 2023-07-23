package Practice1.Task3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Server {
    private PriorityQueue<User> queueUsers;
    private ArrayList<User> statistics = new ArrayList<>();

    public Server(PriorityQueue<User> queueUsers) {
        this.queueUsers = queueUsers;
    }

    public void addRequest(User user) {
        queueUsers.add(user);
        statistics.add(user);
    }

    public void showStatistic() {
        System.out.println("Приоритетная очередь:");
        while (!queueUsers.isEmpty()){
            System.out.println(queueUsers.remove());
        }
        System.out.println("=========================================");
        System.out.println("Статистика за все время (в порядке реального добавления): ");
        statistics.forEach(System.out::println);
    }
}
