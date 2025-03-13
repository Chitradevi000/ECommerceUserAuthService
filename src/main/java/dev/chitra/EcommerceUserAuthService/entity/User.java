package dev.chitra.EcommerceUserAuthService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_USER")
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String token;
    /*
    we already discussed that the relation shio with Role is M:M
     */
    @ManyToMany // its not required that you need to do List<Users> in Role table
    private List<Role> roles;
}
