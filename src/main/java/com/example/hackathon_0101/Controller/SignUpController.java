package com.example.hackathon_0101.Controller;

import com.example.hackathon_0101.Dto.EditDto;
import com.example.hackathon_0101.Dto.UserDto;
import com.example.hackathon_0101.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void saveUser(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping("/mypage")//마이페이지
    public ResponseEntity<EditDto> getMyPage(@RequestParam("id") String id){
        EditDto editDTO = userService.getEditDTO(id);
        return ResponseEntity.ok(editDTO);
    }

    @Transactional
    @PostMapping("/mypage")
    public void editPage(@RequestParam String id,@RequestBody EditDto editDto){
        userService.editMyPage(id,editDto);
    }
}
