package com.example.medbook;

import java.io.Serializable;
import java.util.Date;

public class Medicine implements Serializable {

    // Initialize medicine attributes
    private String name;
    private int doseAmt;
    private String doseUnit;
    private int dailyFreq;
    private Date date;

    /**
     * This is the medicine constructor
     * @param name
     * @param doseAmt
     * @param doseUnit
     * @param dailyFreq
     * @param date
     */
    public Medicine(String name, int doseAmt, String doseUnit, int dailyFreq, Date date) {
        this.name = name;
        this.doseAmt = doseAmt;
        this.doseUnit = doseUnit;
        this.dailyFreq = dailyFreq;
        this.date = date;
    }

    // setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoseAmt() {
        return doseAmt;
    }

    public void setDoseAmt(int doseAmt) {
        this.doseAmt = doseAmt;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit;
    }

    public int getDailyFreq() {
        return dailyFreq;
    }

    public void setDailyFreq(int dailyFreq) {
        this.dailyFreq = dailyFreq;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
