package org.example;

public class UserNonUniqueException extends RuntimeException {
    public UserNonUniqueException() {
        super();
    }

    public UserNonUniqueException(String msg) {
        super(msg);
    }
}