package org.example.mocking.user;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getWelcomeMessage(String userId) {
        User user = repository.findById(userId);
        return (user != null)
            ? "Welcome back, " + user.getName() + "!"
            : "User not found.";
    }
}
