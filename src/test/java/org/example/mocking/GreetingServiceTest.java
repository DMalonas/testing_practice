package org.example.mocking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreetingServiceTest {

    @Test
    void testGreetWithValidName() {
        NameValidator mockValidator = mock(NameValidator.class);
        when(mockValidator.isValid("Alice")).thenReturn(true);

        GreetingService service = new GreetingService(mockValidator);
        String result = service.greet("Alice");

        assertEquals("Hello, Alice!", result);
    }

    @Test
    void testGreetWithInvalidName() {
        NameValidator mockValidator = mock(NameValidator.class);
        when(mockValidator.isValid("123")).thenReturn(false);

        GreetingService service = new GreetingService(mockValidator);
        String result = service.greet("123");

        assertEquals("Invalid name!", result);
    }
}
