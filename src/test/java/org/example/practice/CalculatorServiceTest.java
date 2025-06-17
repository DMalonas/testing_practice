package org.example.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

    MathHelper mockHelper = mock(MathHelper.class);
    CalculatorService service = new CalculatorService(mockHelper);

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
        when(mockHelper.multiply(3, 4)).thenReturn(12);
        assertEquals(12, service.multiply(3, 4));
    }

    @Test
    void testDivide() {
        when(mockHelper.divide(10, 5)).thenReturn(2.0);
        assertEquals(2.0, service.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        when(mockHelper.divide(5, 0)).thenThrow(new IllegalArgumentException("Cannot divide by zero"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
