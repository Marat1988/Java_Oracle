package Task2;

public class Crocodile extends Animal {

    private int bodyLengthMetre; //Длина тела в метрах

    public Crocodile(String name, String familyAnimal, int bodyLength) {
        super(name, familyAnimal);
        this.bodyLengthMetre = bodyLength;
    }

    public int getBodyLength() {
        return bodyLengthMetre;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLengthMetre = bodyLength;
    }

    @Override
    public String toString() {
        return "Крокодил" + "\n" +
                super.toString() + "\n" +
                "Длина тела: " + bodyLengthMetre + " метров.\n";

    }
}
