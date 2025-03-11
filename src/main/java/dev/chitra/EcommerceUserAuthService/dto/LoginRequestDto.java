package dev.chitra.EcommerceUserAuthService.dto;

import dev.chitra.EcommerceUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LoginRequestDto {
    private String email;
    private String password;


}
