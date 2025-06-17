package org.example.mocking;

import org.example.mocking.user.User;
import org.example.mocking.user.UserRepository;
import org.example.mocking.user.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testWelcomeMessageWithValidUser() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById("42")).thenReturn(new User("42", "friend"));

        UserService service = new UserService(mockRepo);
        String message = service.getWelcomeMessage("42");

        assertEquals("Welcome back, friend!", message);
    }

    @Test
    void testWelcomeMessageWithMissingUser() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById("99")).thenReturn(null);

        UserService service = new UserService(mockRepo);
        String message = service.getWelcomeMessage("99");

        assertEquals("User not found.", message);
    }
}
