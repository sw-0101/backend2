package com.example.hackathon_0101.Dto;

public class SearchData {
    private String conference;
    private String year;
    private String keyword;

    @Override
    public String toString() {
        return "SearchData{" +
                "conference='" + conference + '\'' +
                ", year='" + year + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
