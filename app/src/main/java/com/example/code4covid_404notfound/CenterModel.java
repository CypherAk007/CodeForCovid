package com.example.code4covid_404notfound;

public class CenterModel {
    private String centerName;
    private String Fee_type;
    private int Age_limit;
    private String vaccineName;
    private int availableCapacity;

    public CenterModel(String center, String fee, int age, String vName, int capacity) {
        this.centerName = center;
        this.Fee_type = fee;
        this.Age_limit = age;
        this.vaccineName = vName;
        this.availableCapacity = capacity;
    }

    public String getCenterName() {
        return centerName;
    }


    public String getFee_type() {
        return Fee_type;
    }

    public int getAge_limit() {
        return Age_limit;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }
}
