package com.example.models;

import java.util.List;

public class EventResult {
    private int id;
    private String name;
    private String description;
    private String date;
    private List<Athlete> rankList;
    private List<Float> tempList;
    private List<String> scoreList;

    public EventResult(int id, String name, String description, String date, List<Athlete> rankList,
            List<Float> tempList, List<String> scoreList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.rankList = rankList;
        this.tempList = tempList;
        this.scoreList = scoreList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public List<Athlete> getRankList() {
        return rankList;
    }

    public List<Float> getTempList() {
        return tempList;
    }

    public List<String> getScoreList() {
        return scoreList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRankList(List<Athlete> rankList) {
        this.rankList = rankList;
    }

    public void setTempList(List<Float  > tempList) {
        this.tempList = tempList;
    }

    public void setScoreList(List<String> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public String toString() {
        return "EventResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", rankList=" + rankList +
                ", tempList=" + tempList +
                ", scoreList=" + scoreList +
                '}';
    }
}
