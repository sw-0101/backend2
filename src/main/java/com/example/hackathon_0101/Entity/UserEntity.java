package com.example.hackathon_0101.Entity;

import com.example.hackathon_0101.Dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

