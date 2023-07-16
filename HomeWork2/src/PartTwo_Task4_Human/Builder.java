package PartTwo_Task4_Human;

public class Builder extends Human {
    private String post;

    public Builder(String fullName, int age, String post) {
        super(fullName, age);
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Должность: " + post;
    }
}