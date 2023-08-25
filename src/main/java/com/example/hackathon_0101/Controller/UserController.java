package com.example.hackathon_0101.Controller;

import com.example.hackathon_0101.Dto.EditDto;
import com.example.hackathon_0101.Dto.UserDto;
import com.example.hackathon_0101.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void saveUser(@RequestBody UserDto userDto){
        System.out.println("회원가입");
        userService.save(userDto);
    }

   @GetMapping("/mypage")//마이페이지
    public ResponseEntity<EditDto> getMyPage(@RequestParam("id") String id) {
       try {
           EditDto editDTO = userService.getEditDTO(id);
           return ResponseEntity.ok(editDTO);
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.ok().build();
       }

   }
    @Transactional
    @PostMapping("/mypage")
    public void editPage(@RequestParam String id,@RequestBody EditDto editDto){
        System.out.println(editDto.toString());
        userService.editMyPage(id,editDto);
    }
}
