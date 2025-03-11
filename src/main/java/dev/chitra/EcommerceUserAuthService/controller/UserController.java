package dev.chitra.EcommerceUserAuthService.controller;

import dev.chitra.EcommerceUserAuthService.dto.LoginRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.SignUpRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.UserReponseDto;
import dev.chitra.EcommerceUserAuthService.repository.UserRepository;
import dev.chitra.EcommerceUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserReponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return null;
    }

    @GetMapping("/logout")
    public UserReponseDto logout() {
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return null;
    }

    @GetMapping("/validateuser")
    public ResponseEntity validateUser() {
        return null;
    }
}
