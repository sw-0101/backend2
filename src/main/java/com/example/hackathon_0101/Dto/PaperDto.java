package com.example.hackathon_0101.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PaperDto {

    private String id;

    private String email;

    private String title;

    private String titlelink;

    @DateTimeFormat(pattern = "yyyy-mm-dd")

    private Date date;

    private String state;
}
