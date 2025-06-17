package org.example.mocking;

public class GreetingService {
    private final NameValidator validator;

    public GreetingService(NameValidator validator) {
        this.validator = validator;
    }

    public String greet(String name) {
        if (!validator.isValid(name)) {
            return "Invalid name!";
        }
        return "Hello, " + name + "!";
    }
}
