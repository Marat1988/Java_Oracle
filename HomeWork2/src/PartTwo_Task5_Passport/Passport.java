package PartTwo_Task5_Passport;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Passport {
    private int series; //серия
    private int number; //Номер
    private Calendar dateIssue; //Дата Выдачи

    public Passport(int series, int number, Calendar dateIssue) {
        this.series = series;
        this.number = number;
        this.dateIssue = dateIssue;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Calendar getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Calendar dateIssue) {
        this.dateIssue = dateIssue;
    }

    @Override
    public String toString() {
        return "Серия: " + series + "\n" +
                "Номер: " + number + "\n" +
                "Дата выдачи: " + new SimpleDateFormat("dd MMMM yyyy").format(getDateIssue().getTime());
    }
}
