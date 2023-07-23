package Task2;

public class Kangaroo extends Animal {
    private double weight; //Вес

    public Kangaroo(String name, String familyAnimal, double weight) {
        super(name, familyAnimal);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Кенгуру" + "\n" +
                super.toString() + "\n" +
                "Вес: " + weight + " килограмм.\n";
    }
}
