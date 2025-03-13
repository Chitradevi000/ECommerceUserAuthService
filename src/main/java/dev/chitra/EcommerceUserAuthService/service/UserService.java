package dev.chitra.EcommerceUserAuthService.service;

import dev.chitra.EcommerceUserAuthService.dto.LoginRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.SignUpRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.UserReponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    //service class returns DTO
    //DTO conversion is a service thing
    //this is an Interface , lets create a method declaration

    UserReponseDto singUpUser(SignUpRequestDto signUpRequestDto);
    UserReponseDto loginUser(LoginRequestDto loginRequestDto);
    boolean validateUser(String token);
    boolean logout(String token);
}
