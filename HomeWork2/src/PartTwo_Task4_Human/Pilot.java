package PartTwo_Task4_Human;

public class Pilot extends Human {
    private int numberDepartures; //Количество вылетов

    public Pilot(String fullName, int age, int numberDepartures) {
        super(fullName, age);
        this.numberDepartures = numberDepartures;
    }

    public String getFullName() {
        return super.getFullName();
    }

    public int getNumberDepartures() {
        return numberDepartures;
    }

    public void setNumberDepartures(int numberDepartures) {
        this.numberDepartures = numberDepartures;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Количество вылетов: " + numberDepartures;
    }


}
