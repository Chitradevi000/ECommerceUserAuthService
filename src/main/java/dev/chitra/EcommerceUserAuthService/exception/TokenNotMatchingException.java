package dev.chitra.EcommerceUserAuthService.exception;

public class TokenNotMatchingException extends RuntimeException{
    public TokenNotMatchingException() {
    }

    public TokenNotMatchingException(String message) {
        super(message);
    }
}
