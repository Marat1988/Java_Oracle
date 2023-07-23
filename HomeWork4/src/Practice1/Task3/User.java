package Practice1.Task3;

public class User implements Comparable<User> {
    private String name;
    private String time;
    private int priority;

    public User(String name, String time, int priority) {
        this.name = name;
        this.time = time;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Пользователь: " + name + "\n" +
                "Время: " + time + "\n" +
                "Приоритет: " + priority;
    }

    @Override
    public int compareTo(User o) {
        return this.priority - o.priority;
    }

}
