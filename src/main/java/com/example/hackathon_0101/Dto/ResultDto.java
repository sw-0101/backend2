package com.example.hackathon_0101.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultDto {
    private String title;
    private String link;

    public ResultDto(String title, String link) {
        this.title = title;
        this.link=link;
    }
    //private List<String> Date;

//    public ResultDto(String title, String link) {
//        this.title = Collections.singletonList(title);
//        this.link = Collections.singletonList(link);
//    }


}
