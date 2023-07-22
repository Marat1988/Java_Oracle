package HomeWork1;

public class Builder extends Human {

    private String specialization;

    public Builder(int age, String fullName, String specialization) {
        super(age, fullName);
        this.specialization = specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Специализация: " + specialization + "\n";
    }
}
