package Task5;

public abstract class MusicDevice { //Музыкальный инструмент
    private String name;

    public MusicDevice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void Sound();

    public abstract void Show();

    public abstract void Desc();

    public abstract void History();
}
