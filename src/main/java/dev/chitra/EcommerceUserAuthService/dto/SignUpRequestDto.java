package dev.chitra.EcommerceUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String firstName;
    private UUID roleId;
}
