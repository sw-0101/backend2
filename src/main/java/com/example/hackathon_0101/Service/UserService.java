package com.example.hackathon_0101.Service;

import com.example.hackathon_0101.Dto.EditDto;
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

    public void editMyPage(String id,EditDto editDto){
        UserEntity findUser = findUserById(id);
        findUser.setName(editDto.getName());
        findUser.setBirth(editDto.getBirth());
        findUser.setCollege(editDto.getCollege());
        findUser.setDegree(editDto.getDegree());
        findUser.setMajor(editDto.getMajor());
        findUser.setMinor(editDto.getMinor());
        findUser.setField(editDto.getField());
        findUser.setFavor_depth(editDto.getFavor_depth());
        findUser.setOwn_paper(editDto.getOwn_paper());

    }
    public EditDto getEditDTO(String id){
        UserEntity findUser = findUserById(id);
        System.out.println(findUser);
        return EditDto.toEditDTO(findUser);
    }

    private UserEntity findUserById(String id) {
        return userRepository.findById(id);
    }
}
