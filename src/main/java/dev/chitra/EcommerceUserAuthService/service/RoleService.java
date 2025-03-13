package dev.chitra.EcommerceUserAuthService.service;

import dev.chitra.EcommerceUserAuthService.dto.RoleRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.RoleResponseDto;
import dev.chitra.EcommerceUserAuthService.entity.Role;

public interface RoleService {
    RoleResponseDto createRole(RoleRequestDto role);
}
