package Task4;

public abstract class Device {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  abstract void Sound();
    public  abstract void Show();
    public abstract void Desc();
}
