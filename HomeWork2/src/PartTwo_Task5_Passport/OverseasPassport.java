package PartTwo_Task5_Passport;

import java.util.Calendar;

public class OverseasPassport extends Passport {
    private int numberOverseasPassport; //Номер заграничного паспорта
    private String visaInfo; //Информация о визах

    public OverseasPassport(int series, int number, Calendar dateIssue, int numberOverseasPassport, String visaInfo) {
        super(series, number, dateIssue);
        this.numberOverseasPassport = numberOverseasPassport;
        this.visaInfo = visaInfo;
    }

    public int getNumberOverseasPassport() {
        return numberOverseasPassport;
    }

    public void setNumberOverseasPassport(int numberOverseasPassport) {
        this.numberOverseasPassport = numberOverseasPassport;
    }

    public String getVisaInfo() {
        return visaInfo;
    }

    public void setVisaInfo(String visaInfo) {
        this.visaInfo = visaInfo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Номер заграничного паспорта: " + numberOverseasPassport + "\n" +
                "Информация о визах: " + visaInfo + "\n";
    }
}
