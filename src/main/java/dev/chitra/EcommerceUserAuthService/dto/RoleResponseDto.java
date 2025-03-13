package dev.chitra.EcommerceUserAuthService.dto;

import dev.chitra.EcommerceUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDto {
    private String role;
    private String description;
//create a mapper in DTO

    public static RoleResponseDto from(Role role) {
        RoleResponseDto dto = new RoleResponseDto();
        dto.setRole(role.getRole());
        dto.setDescription(role.getDescription());
        return dto;
    }
}
