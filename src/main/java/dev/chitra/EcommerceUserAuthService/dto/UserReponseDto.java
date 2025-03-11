package dev.chitra.EcommerceUserAuthService.dto;

import dev.chitra.EcommerceUserAuthService.entity.Role;
import dev.chitra.EcommerceUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.instrument.classloading.ResourceOverridingShadowingClassLoader;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserReponseDto {
    private String name;
    private String email;
    private List<RoleResponseDto> listOfRoles;

    //im gonna write a mapper below


    //1. User to UserResponseDto
    public static UserReponseDto from(User user) {
        if(user == null) return null;
        UserReponseDto userDto = new UserReponseDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setListOfRoles(new ArrayList<>());
        //how to convert the below loop into lambda
//        for(Role role : user.getRoles()) {
//            RoleResponseDto roleResponseDto = new RoleResponseDto();
//            roleResponseDto.setRole(role.getRole());
//            roleResponseDto.setDescription(role.getDescription());
//            userDto.getListOfRoles().add(roleResponseDto);
//        }

        user.getRoles().stream()
                .map(a->
                        {
                            RoleResponseDto responseDto = new RoleResponseDto();
                            responseDto.setRole(a.getRole());
                            responseDto.setDescription(a.getDescription());
                            return responseDto;
                        }).
                        forEach(userDto.getListOfRoles()::add);

        return userDto;
    }

    //2.UserResponseDto to User
    public User from(UserReponseDto userDto) {
        return null;
    }
}
