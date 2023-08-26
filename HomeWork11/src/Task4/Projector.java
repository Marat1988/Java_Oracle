package Task4;

import java.util.Comparator;

public class Projector {
    private String name;
    private int yearRelease;
    private double price;
    private String manufacturer;

    public Projector(String name, int yearRelease, double price, String manufacturer) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "{\"name\":" + name +
                "\"yearRelease\":" + yearRelease +
                "\"price\":" + price +
                "\"manufacturer\":" + manufacturer + "}";
    }
}
