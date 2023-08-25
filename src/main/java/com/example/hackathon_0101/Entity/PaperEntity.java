package com.example.hackathon_0101.Entity;

import com.example.hackathon_0101.Dto.PaperDto;
import com.example.hackathon_0101.Dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="paper")
public class PaperEntity {
    @Id
    @GeneratedValue
    private Long number;

    @Column
    private String id;

    @Column
    private String email;

    @Column
    private String title;

    @Column
    private String titlelink;

    @Column
    private Date date;

    @Column
    private State State;

    public static PaperEntity toPaperEntity(PaperDto paperDto){
        PaperEntity paperEntity = new PaperEntity();
        paperEntity.setId(paperDto.getId());
        paperEntity.setEmail(paperDto.getEmail());
        paperEntity.setTitle(paperDto.getTitle());
        paperEntity.setTitlelink(paperDto.getTitlelink());
        paperEntity.setDate(paperDto.getDate());
        paperEntity.setState(paperDto.getState());
        return paperEntity;
    }
}
