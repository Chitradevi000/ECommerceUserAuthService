package dev.chitra.EcommerceUserAuthService.controller;

import dev.chitra.EcommerceUserAuthService.dto.LoginRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.SignUpRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.UserReponseDto;
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
    public ResponseEntity<UserReponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {

       return ResponseEntity.ok(userService.loginUser(loginRequestDto));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String authToken) { // here the token input from headers
        return ResponseEntity.ok(userService.logout(authToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserReponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(userService.singUpUser(signUpRequestDto));
    }

    @GetMapping("/validateuser")
    public ResponseEntity validateUser(@RequestHeader("Authorization") String authToken) { // here the token input from headers
       return ResponseEntity.ok(userService.validateUser(authToken));
    }
}
