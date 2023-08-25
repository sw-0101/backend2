package com.example.hackathon_0101.Controller;

import com.example.hackathon_0101.Dto.UserDto;
import com.example.hackathon_0101.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void saveUser(@RequestBody UserDto userDto){ //@RequestParam String name, String email,String id,String phonenum
        System.out.println("회원가입");
        //UserDto userDto = new UserDto();
        //userDto.setName(name);
        //userDto.setID(id);
        //userDto.setPhoneNum(phonenum);
        //userDto.setEmail(email);
        System.out.println(userDto);
        userService.save(userDto);
    }
}
