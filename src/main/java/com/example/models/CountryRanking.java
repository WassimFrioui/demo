package com.example.models;

public class CountryRanking {
    private int Id;
    private String Country;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    public CountryRanking(int Id, String Country, int goldMedals, int silverMedals, int bronzeMedals) {
        this.Id = Id;
        this.Country = Country;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(int goldMedals) {
        this.goldMedals = goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(int silverMedals) {
        this.silverMedals = silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(int bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public void addCountryRanking() {

    }

    public void modifyCountryRanking() {
    }

    public void deleteCountryRanking() {
    }

    @Override
    public String toString() {
        return "CountryRanking{" +
                "Id=" + Id +
                ", Country='" + Country + '\'' +
                ", goldMedals=" + goldMedals +
                ", silverMedals=" + silverMedals +
                ", bronzeMedals=" + bronzeMedals +
                '}';
    }
}
