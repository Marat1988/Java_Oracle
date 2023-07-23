package Task1;

public class Pilot extends Human {
    private int flightHours; //Всего часов полета

    public Pilot(int age, String fullName, int flightHours) {
        super(age, fullName);
        this.flightHours = flightHours;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Всего часов полета: " + flightHours + "\n";
    }
}
