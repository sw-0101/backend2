package com.example.hackathon_0101.Dto;

import com.example.hackathon_0101.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter @Getter
public class EditDto {
    private String name;
    private LocalDate birth;
    private String college;
    private String degree;
    private String major;
    private String minor;
    private String field;
    private long favor_depth;
    private long own_paper;

    public static EditDto toEditDTO(UserEntity user){
        EditDto dto = new EditDto();
        dto.setName(user.getName());
        dto.setBirth(user.getBirth());
        dto.setCollege(user.getCollege());
        dto.setDegree(user.getDegree());
        dto.setField(user.getField());
        dto.setMajor(user.getMajor());
        dto.setMinor(user.getMinor());
        dto.setFavor_depth(user.getFavor_depth());
        dto.setOwn_paper(user.getOwn_paper());
        return dto;
    }
}
