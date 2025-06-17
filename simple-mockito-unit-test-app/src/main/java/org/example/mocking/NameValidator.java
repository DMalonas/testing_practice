package org.example.mocking;

public class NameValidator {
    public boolean isValid(String name) {
        return name != null && name.matches("[A-Za-z]+");
    }
}
