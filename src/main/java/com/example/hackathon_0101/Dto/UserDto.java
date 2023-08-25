package com.example.hackathon_0101.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.PriorityQueue;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long number;

    private String name;

    private String email;

    private String id;

    private String phonenum;
    private String Major;
    private String Minor;
    private String College;
    private LocalDate Birth;
    private String degree;
    private String field;//주 분야
    private long own_paper;

}
