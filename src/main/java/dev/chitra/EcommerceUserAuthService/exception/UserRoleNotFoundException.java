package dev.chitra.EcommerceUserAuthService.exception;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException() {
    }

    public UserRoleNotFoundException(String message) {
        super(message);
    }
}
