package PartTwo_Task4_Human;

public class Sailor extends Human {
    private int numberFlights; //Количество рейсов

    public Sailor(String fullName, int age, int numberFlights) {
        super(fullName, age);
        this.numberFlights = numberFlights;
    }

    public int getNumberFlights() {
        return numberFlights;
    }

    public void setNumberFlights(int numberFlights) {
        this.numberFlights = numberFlights;
    }


    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Количество рейсов: " + numberFlights;
    }
}
