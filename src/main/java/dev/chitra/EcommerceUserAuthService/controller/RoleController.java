package dev.chitra.EcommerceUserAuthService.controller;

import dev.chitra.EcommerceUserAuthService.dto.RoleRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.RoleResponseDto;
import dev.chitra.EcommerceUserAuthService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createrole")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto roleRequestDto) {
        return ResponseEntity.ok(roleService.createRole(roleRequestDto));
    }

}
