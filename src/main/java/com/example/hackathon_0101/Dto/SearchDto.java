package com.example.hackathon_0101.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
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

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
