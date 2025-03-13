package dev.chitra.EcommerceUserAuthService.service;

import dev.chitra.EcommerceUserAuthService.dto.RoleRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.RoleResponseDto;
import dev.chitra.EcommerceUserAuthService.entity.Role;
import dev.chitra.EcommerceUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

   @Autowired
   private RoleRepository roleRepository;

    @Override
    public RoleResponseDto createRole(RoleRequestDto role) {
        Role roleEntity = new Role();
        roleEntity.setRole(role.getRoleName());
        roleEntity.setDescription(role.getRoleDescription());
        return RoleResponseDto.from(roleRepository.save(roleEntity));
    }
}
