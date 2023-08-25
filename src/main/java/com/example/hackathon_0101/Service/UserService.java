package com.example.hackathon_0101.Service;

import com.example.hackathon_0101.Dto.UserDto;
import com.example.hackathon_0101.Entity.UserEntity;
import com.example.hackathon_0101.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto){  //회원가입
        UserEntity userEntity = UserEntity.toUserEntity(userDto);
        userRepository.save(userEntity);
        System.out.println("회원가입 완료");
    }
}
