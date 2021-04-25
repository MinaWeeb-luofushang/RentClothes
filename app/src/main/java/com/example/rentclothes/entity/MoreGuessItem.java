package com.example.rentclothes.entity;

public class MoreGuessItem {
    private int id;
    private String guessUrl;
    private String guessTitle;
    private String guessType;
    private int guessNumber;

    public MoreGuessItem(String guessUrl,String guessTitle,
                         String guessType,int guessNumber){
        this.guessUrl = guessUrl;
        this.guessTitle = guessTitle;
        this.guessType = guessType;
        this.guessNumber = guessNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuessUrl() {
        return guessUrl;
    }

    public void setGuessUrl(String guessUrl) {
        this.guessUrl = guessUrl;
    }

    public String getGuessTitle() {
        return guessTitle;
    }

    public void setGuessTitle(String guessTitle) {
        this.guessTitle = guessTitle;
    }

    public String getGuessType() {
        return guessType;
    }

    public void setGuessType(String guessType) {
        this.guessType = guessType;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }
}
