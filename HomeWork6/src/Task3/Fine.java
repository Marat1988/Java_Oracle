package Task3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fine { //Штраф
    private Calendar dateFine; //Дата штрафа
    private String description; //Описание штрафа
    private double amountFine; //Сумма штрафа
    private TypeFine typeFine; //Тип штрафа

    public Fine(Calendar dateFine, String description, double amountFine, TypeFine typeFine) {
        this.dateFine = dateFine;
        this.description = description;
        this.amountFine = amountFine;
        this.typeFine = typeFine;
    }

    public Calendar getDateFine() {
        return dateFine;
    }

    public void setDateFine(Calendar dateFine) {
        this.dateFine = dateFine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmountFine() {
        return amountFine;
    }

    public void setAmountFine(double amountFine) {
        this.amountFine = amountFine;
    }

    public TypeFine getTypeFine() {
        return typeFine;
    }

    public int getTypeFineCode() {
        return typeFine.ordinal();
    }

    @Override
    public String toString() {
        return "{\"dateFine\": \"" + new SimpleDateFormat("dd MMMM yyyy").format(dateFine.getTime()) + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"amountFine\": " + amountFine + "," +
                "\"typeFine\": \"" + typeFine + "\"}";

    }
}
