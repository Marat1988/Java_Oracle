package Task3;

public class Device {
    private String name;
    private int yearRelease;
    private double price;
    private String color;
    private TYPE_DEVICE typeDevice;

    public Device(String name, int yearRelease, double price, String color, TYPE_DEVICE typeDevice) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.price = price;
        this.color = color;
        this.typeDevice = typeDevice;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TYPE_DEVICE getTypeDevice() {
        return typeDevice;
    }

    public int getTypeDeviceCode() {
        return typeDevice.ordinal();
    }

    public void setTypeDevice(TYPE_DEVICE typeDevice) {
        this.typeDevice = typeDevice;
    }

    @Override
    public String toString() {
        return "{\"name\":" + name +
                "\"yearRelease\":" + yearRelease +
                "\"price\":" + price +
                "\"color\":" + color +
                "\"typeDevice\":" + typeDevice + "}";

    }
}
