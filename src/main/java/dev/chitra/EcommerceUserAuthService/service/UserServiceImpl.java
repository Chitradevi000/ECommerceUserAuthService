package dev.chitra.EcommerceUserAuthService.service;

import dev.chitra.EcommerceUserAuthService.dto.LoginRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.SignUpRequestDto;
import dev.chitra.EcommerceUserAuthService.dto.UserReponseDto;
import dev.chitra.EcommerceUserAuthService.entity.Role;
import dev.chitra.EcommerceUserAuthService.entity.User;
import dev.chitra.EcommerceUserAuthService.exception.InvalidUserCredentialsException;
import dev.chitra.EcommerceUserAuthService.exception.UserRoleNotFoundException;
import dev.chitra.EcommerceUserAuthService.repository.RoleRepository;
import dev.chitra.EcommerceUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserReponseDto singUpUser(SignUpRequestDto signUpRequestDto) {
       Role role= roleRepository.findById(signUpRequestDto.getRoleId()).orElseThrow(
                () -> new UserRoleNotFoundException("User Role not found")
        );
       //I need to store the User in Userrepo and share the dto
        User user=new User();
        user.setName(signUpRequestDto.getFirstName());
        user.setEmail(signUpRequestDto.getEmail());
        user.setPassword(signUpRequestDto.getPassword()); // we should not save the pwd like this, we are going to use Bcrypt for this we are exclude the Spring Securing from the mail application - refer the mail class
        user.setRoles(List.of(role));
        return UserReponseDto.from(userRepository.save(user));//converting the USer to DTO and return
    }

    @Override
    public UserReponseDto loginUser(LoginRequestDto loginRequestDto) {
        //validate the User with his UUID
        User savedUser= userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(
                ()-> new UserRoleNotFoundException("User not found with this email")
        );

        //if user is there, you need to compare the pwd with Bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(loginRequestDto.getPassword());
        if(bCryptPasswordEncoder.matches(loginRequestDto.getPassword(),password)){
            //generate a token
            String token = savedUser.getEmail() + savedUser.getPassword()+ LocalDateTime.now();
            String bcryptToken=bCryptPasswordEncoder.encode(token);
            savedUser.setToken(bcryptToken);
        }
        else {
            throw new InvalidUserCredentialsException("Password Not marching");
        }
        userRepository.save(savedUser);
        return UserReponseDto.from(savedUser);
    }

    @Override
    public boolean validateUser(String token) {
        //verify the token with the db saved token
        userRepository.findByToken(token).orElseThrow(
                ()-> new UserRoleNotFoundException("User not found with this token")
        );
        return true;
    }

    @Override
    public boolean logout(String token) {
       User savedUser= userRepository.findByToken(token).orElseThrow(
                ()-> new UserRoleNotFoundException("User not found with this token")
        );
       savedUser.setToken(null);
       userRepository.delete(savedUser);
       return true;
    }
}