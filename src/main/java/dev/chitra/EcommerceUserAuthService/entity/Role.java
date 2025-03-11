package dev.chitra.EcommerceUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_ROLE")
@Getter
@Setter
public class Role extends BaseModel {
    private String role;
    private String description;
}
