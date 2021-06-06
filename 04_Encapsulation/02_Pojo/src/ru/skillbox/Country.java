package ru.skillbox;

public class Country {

    private String countryName;
    private int populateStat;
    private int area;
    private String nameOfCapital;
    private boolean landlocked;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setPopulateStat(int populateStat) {
        this.populateStat = populateStat;
    }

    public int getPopulateStat() {
        return populateStat;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public void setNameOfCapital(String nameOfCapital) {
        this.nameOfCapital = nameOfCapital;
    }

    public String getNameOfCapital() {
        return nameOfCapital;
    }

    public void setLandlocked(boolean landlocked) {
        this.landlocked = landlocked;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

}
