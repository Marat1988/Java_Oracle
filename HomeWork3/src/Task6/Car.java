package Task6;

public class Car {
    private String nameAuto;
    private String manufacturer;
    private int yearRelease;
    private double engineCapacity;

    public Car(String nameAuto, String manufacturer, int yearRelease, double engineCapacity) {
        this.nameAuto = nameAuto;
        this.manufacturer = manufacturer;
        this.yearRelease = yearRelease;
        this.engineCapacity = engineCapacity;
    }

    public String getNameAuto() {
        return nameAuto;
    }

    public void setNameAuto(String nameAuto) {
        this.nameAuto = nameAuto;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void sellCar(String nameBuyer) {
        System.out.println("Покупатель " + nameBuyer);
    }

    public void sellCar(String nameBuyer, int cost) {
        sellCar(nameBuyer);
        System.out.println("Продана за " + cost + " рублей");
    }

    @Override
    public String toString() {
        return "Название авто: " + nameAuto + "\n" +
                "Производитель: " + manufacturer + "\n" +
                "Год выпуска: " + yearRelease + "\n" +
                "Объем двигателя (л.c.): " + engineCapacity;
    }
}
