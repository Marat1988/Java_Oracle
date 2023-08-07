package Task1;

public class Statistic { //Для ля хранения статистики количества пассажиров на остановке при пребывании катера на остановку.
    private int arrivalTime; //Время прибытия катера на остановку (в минутах)
    private int countPassenger; //Количество пассажиров на остановке

    public Statistic(int arrivalTime, int countPassenger) {
        this.arrivalTime = arrivalTime;
        this.countPassenger = countPassenger;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCountPassenger() {
        return countPassenger;
    }

    public void setCountPassenger(int countPassenger) {
        this.countPassenger = countPassenger;
    }
}
