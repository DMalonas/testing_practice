package org.example.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, service.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, service.subtract(4, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(12, service.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, service.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
