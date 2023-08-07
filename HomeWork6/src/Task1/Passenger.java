package Task1;

public class Passenger {
    private String name;
    private int arrivalTimeStop; //Время, когда пассажир пришел на остановку. Конвертируется в минуты. Например, пассажир пришел на остановку в 8:00 утра.
                                //Следовательно, это будет 8 * 60 = 480 минут

    private int departureTimeStop; //Время убытия пассажира с остановки. Аналогично с arrivalTimeStop

    public Passenger(String name, int arrivalTimeStop) {
        this.name = name;
        this.arrivalTimeStop = arrivalTimeStop;
    }

    public int getArrivalTimeStop() {
        return arrivalTimeStop;
    }

    public void setArrivalTimeStop(int arrivalTimeStop) {
        this.arrivalTimeStop = arrivalTimeStop;
    }

    public void setDepartureTimeStop(int departureTimeStop) {
        this.departureTimeStop = departureTimeStop;
    }

    public String getName() {
        return name;
    }

    public int getDepartureTimeStop() {
        return departureTimeStop;
    }

    @Override
    public String toString() {
        return name + " пришел на остановку. Время прихода: " + arrivalTimeStop / 60 + ":" + (((arrivalTimeStop % 60) < 10) ? "0" + arrivalTimeStop % 60 : arrivalTimeStop % 60);
    }
}
