package Task1;

public class Sailor extends Human {
    private int countFlights; //Количество рейсов

    public Sailor(int age, String fullName, int countFlights) {
        super(age, fullName);
        this.countFlights = countFlights;
    }

    public int getCountFlights() {
        return countFlights;
    }

    public void setCountFlights(int countFlights) {
        this.countFlights = countFlights;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Количество рейсов: " + countFlights + "\n";
    }
}
