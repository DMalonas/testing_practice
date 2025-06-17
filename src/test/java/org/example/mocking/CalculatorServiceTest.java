package org.example.mocking;

import org.example.mocking.test.CalculatorService;
import org.example.mocking.test.MathHelper;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalculatorServiceTest {
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

    @Test
    void testMultiplyWithSpy() {
        MathHelper realHelper = new MathHelper();
        MathHelper spyHelper = spy(realHelper);
        CalculatorService serviceWithSpy = new CalculatorService(spyHelper);

        // Override one behavior
        doReturn(100).when(spyHelper).multiply(5, 5);

        assertEquals(100, serviceWithSpy.multiply(5, 5)); // uses the mocked return
        assertEquals(20, serviceWithSpy.multiply(4, 5));  // uses real method
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 0, 0",
            "-1, -2, -3",
            "10, -5, 5"
    })
    void testAddMultipleInputs(int a, int b, int expected) {
        CalculatorService service = new CalculatorService(new MathHelper());
        assertEquals(expected, service.add(a, b));
    }

}
