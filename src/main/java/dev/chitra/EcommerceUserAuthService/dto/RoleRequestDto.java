package dev.chitra.EcommerceUserAuthService.dto;

import dev.chitra.EcommerceUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDto {
    private String roleName;
    private String roleDescription;


}
