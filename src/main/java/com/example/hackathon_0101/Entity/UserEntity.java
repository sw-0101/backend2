package com.example.hackathon_0101.Entity;

import com.example.hackathon_0101.Dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="user_info")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long number;

    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNum;
    private String Major;
    private String Minor;
    private String College;
    private LocalDate Birth;
    private String degree;
    private String field;//주 분야
    private long own_paper;
    private long favor_depth;

    public static UserEntity toUserEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setNumber(userEntity.getNumber());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhoneNum(userDto.getPhonenum());

        return userEntity;
    }
}

