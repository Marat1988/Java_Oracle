package Task2;

public class Tiger extends Animal {
    private double runningSpeed; //Скорость бега

    public Tiger(String name, String familyAnimal, double runningSpeed) {
        super(name, familyAnimal);
        this.runningSpeed = runningSpeed;
    }

    public double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    @Override
    public String toString() {
        return "Тирг" + "\n" +
                super.toString() + "\n" +
                "Скорость бега: " + runningSpeed + " км/ч\n";
    }
}
